package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage thisStage;
	String file = "";

	@FXML
	TextArea txtAreaLeft;

	@FXML
	TextArea txtAreaRight;

	@FXML
	Button btnSendText;

	@FXML
	ImageView imgLeft;

	@FXML
	ImageView imgRight;

	@FXML
	Button btnCapture;

	@FXML
	Button btnSaveImage;

	@FXML
	Button btnStartCamera;

	@FXML
	Button btnShareVideo;

	// a timer for acquiring the video stream
	private ScheduledExecutorService timer;
	// the OpenCV object that realizes the video capture
	private VideoCapture capture = new VideoCapture();
	// a flag to change the button behavior
	private boolean cameraActive = false;
	// the id of the camera to be used
	private static int cameraId = 0;

	Mat frame = null;
	private ScheduledExecutorService timer2;
	private boolean shareIsOn = false;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendTextClick(ActionEvent event) {

		txtAreaRight.setText(txtAreaLeft.getText());
	}

	public void capturePhotoClick(ActionEvent event) {

		// Setting the image view
		imgRight.setImage(imgLeft.getImage());

		// Setting the preserve ratio of the image view
		imgRight.setPreserveRatio(true);

	}

	public void saveImageClick(ActionEvent event) {
		// Saving the Image
		String file = "snapshot.jpg";

		// Saving it again
		Imgcodecs.imwrite(file, frame);
	}

	public void shareVideoClick(ActionEvent event) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		if(!shareIsOn)
		{
			this.shareIsOn = true;

		// grab a frame every 33 ms (30 frames/sec)
		Runnable frameGrabber = new Runnable() {

			@Override
			public void run() {
				// effectively grab and process a single frame
				// frame = grabFrame();
				// convert and show the frame
				Image imageToShow = Utils.mat2Image(frame);
				updateImageView(imgRight, imageToShow);
			}
		};

		btnShareVideo.setText("Stop Sharing");
		this.timer2 = Executors.newSingleThreadScheduledExecutor();
		this.timer2.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
		
		}
		else
		{
			btnShareVideo.setText("Share Video");
			shareIsOn = false;

			timer2.shutdown();
			try {
				timer2.awaitTermination(33, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@FXML
	protected void startCamera(ActionEvent event) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		if (!this.cameraActive) {
			// start the video capture
			this.capture.open(cameraId);

			// is the video stream available?
			if (this.capture.isOpened()) {
				this.cameraActive = true;

				// grab a frame every 33 ms (30 frames/sec)
				Runnable frameGrabber = new Runnable() {

					@Override
					public void run() {
						// effectively grab and process a single frame
						frame = grabFrame();
						// convert and show the frame
						Image imageToShow = Utils.mat2Image(frame);
						updateImageView(imgLeft, imageToShow);
					}
				};

				this.timer = Executors.newSingleThreadScheduledExecutor();
				this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);

				// update the button content
				this.btnStartCamera.setText("Stop Camera");
			} else {
				// log the error
				System.err.println("Impossible to open the camera connection...");
			}
		} else {
			// the camera is not active at this point
			this.cameraActive = false;
			// update again the button content
			this.btnStartCamera.setText("Start Camera");

			// stop the timer
			this.stopAcquisition();
		}
	}

	/**
	 * Get a frame from the opened video stream (if any)
	 *
	 * @return the {@link Mat} to show
	 */
	private Mat grabFrame() {
		// init everything
		Mat frame = new Mat();

		// check if the capture is open
		if (this.capture.isOpened()) {
			try {
				// read the current frame
				this.capture.read(frame);

				// if the frame is not empty, process it
				if (!frame.empty()) {
					Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
				}

			} catch (Exception e) {
				// log the error
				System.err.println("Exception during the image elaboration: " + e);
			}
		}

		return frame;
	}

	/**
	 * Stop the acquisition from the camera and release all the resources
	 */
	private void stopAcquisition() {
		if (this.timer != null && !this.timer.isShutdown()) {
			try {
				// stop the timer
				this.timer.shutdown();
				this.timer.awaitTermination(33, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// log any exception
				System.err.println("Exception in stopping the frame capture, trying to release the camera now... " + e);
			}
		}

		if (this.capture.isOpened()) {
			// release the camera
			this.capture.release();
		}
	}

	private void updateImageView(ImageView view, Image image) {
		Utils.onFXThread(view.imageProperty(), image);
		// Add this code please
		frame = grabFrame();

	}

	/**
	 * On application close, stop the acquisition from the camera
	 */
	protected void setClosed() {
		this.stopAcquisition();
	}

	public static void main(String[] args) {
		// load the native OpenCV library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		launch(args);
	}
}
