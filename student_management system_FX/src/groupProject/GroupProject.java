	package groupProject;
	
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
	
	import javafx.application.Application;
	import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.paint.*;
	import javafx.scene.control.Button;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;
	
	public class GroupProject extends Application implements EventHandler<ActionEvent> {
	
		private Button btnAddStudent;
		private Button btnAddCourse;
		private Button btnAddInstructor;
		private TextField txtCourseName;
		private ComboBox<String> cboBuilding;
		private TextField txtRoom;
		private TextField txtMaxCap;
	
		private TextField txtStudentName;
		private ComboBox<String> cboYear;
		private TextField txtMajor;
		private TextField txtGPA;
		private TextField txtEmail;
	
		private TextField txtInstrEmail;
		private TextField txtInstructorName;
		private ComboBox<String> cboPrefix;
		private TextField txtOffice;
		private TextField txtDept;
	
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Instructor> instructors = new ArrayList<Instructor>();
	
		private TextArea txtTextPane;
	
		@Override
		public void start(Stage primaryStage) {
	
			// Student Controls
			Label lblAddStudent = new Label("Add Student:");
			Label lblStudentName = new Label("Name:");
			txtStudentName = new TextField();
			Label lblYear = new Label("Year:");
			cboYear = new ComboBox<String>();
			cboYear.getItems().addAll("Freshman", "Sophomore", "Junior", "Senior");
			Label lblMajor = new Label("Major:");
			txtMajor = new TextField();
			Label lblGPA = new Label("GPA:");
			txtGPA = new TextField();
			Label lblEmail = new Label("Email:");
			txtEmail = new TextField();
	
			// https://www.w3schools.com/colors/colors_picker.asp
	
			btnAddStudent = new Button("Add Student ->");
			//btnAddStudent.setStyle(
			//		"-fx-font-size:12px;-fx-font-weight: bold;-fx-text-fill:#5E34B1;-fx-background-color:#b8b894;");
			btnAddStudent.setOnAction(this);
	
			// Create and set student pane
			GridPane studentPane = new GridPane();
			studentPane.setAlignment(Pos.CENTER);
			studentPane.add(lblAddStudent, 0, 0);
			studentPane.add(lblStudentName, 0, 1);
			studentPane.add(txtStudentName, 1, 1);
			studentPane.add(lblYear, 0, 2);
			studentPane.add(cboYear, 1, 2);
			studentPane.add(lblMajor, 0, 3);
			studentPane.add(txtMajor, 1, 3);
			studentPane.add(lblGPA, 0, 4);
			studentPane.add(txtGPA, 1, 4);
			studentPane.add(lblEmail, 0, 5);
			studentPane.add(txtEmail, 1, 5);
			studentPane.add(btnAddStudent, 1, 6);
	
			// Course Controls
			Label lblAddCourse = new Label("Add Course:");
			Label lblCourseName = new Label("Name:");
			txtCourseName = new TextField();
			Label lblBuilding = new Label("Building:");
			cboBuilding = new ComboBox<String>();
			cboBuilding.getItems().addAll("Showker", "Chandler", "Burrus Hall");
			Label lblRoom = new Label("Room:");
			txtRoom = new TextField();
			Label lblMaxCap = new Label("Max Capacity:");
			txtMaxCap = new TextField();
			btnAddCourse = new Button("Add Course ->");
			btnAddCourse.setStyle(
					"-fx-font-size:12px;-fx-font-weight: bold;-fx-text-fill:#5E34B1;-fx-background-color:#b8b894;");
			btnAddCourse.setOnAction(this);
	
			// Create and set course pane
			GridPane coursePane = new GridPane();
			// coursePane.setAlignment(Pos.CENTER);
			coursePane.add(lblAddCourse, 0, 0);
			coursePane.add(lblCourseName, 0, 1);
			coursePane.add(txtCourseName, 1, 1);
			coursePane.add(lblBuilding, 0, 2);
			coursePane.add(cboBuilding, 1, 2);
			coursePane.add(lblRoom, 0, 3);
			coursePane.add(txtRoom, 1, 3);
			coursePane.add(lblMaxCap, 0, 4);
			coursePane.add(txtMaxCap, 1, 4);
			coursePane.add(btnAddCourse, 1, 5);
	
			// Instructor Controls
			Label lblAddInstructor = new Label("Add Instructor:");
			Label lblInstructorName = new Label("Name:");
			txtInstructorName = new TextField();
			Label lblPrefix = new Label("Prefix:");
			cboPrefix = new ComboBox<String>();
			cboPrefix.getItems().addAll("Dr.", "Ms.", "Mrs.", "Mr.");
			Label lblOffice = new Label("Office:");
			txtOffice = new TextField();
			Label lblDepartment = new Label("Department:");
			txtDept = new TextField();
			Label lblInstrEmail = new Label("Email:");
			txtInstrEmail = new TextField();
			btnAddInstructor = new Button("Add Instructor ->");
			btnAddInstructor.setStyle(
					"-fx-font-size:12px;-fx-font-weight: bold;-fx-text-fill:#5E34B1;-fx-background-color:#b8b894;");
			btnAddInstructor.setOnAction(this);
	
			// Create and set instructor pane
			GridPane instructorPane = new GridPane();
			instructorPane.setAlignment(Pos.CENTER);
			instructorPane.add(lblAddInstructor, 0, 0);
			instructorPane.add(lblInstructorName, 0, 1);
			instructorPane.add(txtInstructorName, 1, 1);
			instructorPane.add(lblPrefix, 0, 2);
			instructorPane.add(cboPrefix, 1, 2);
			instructorPane.add(lblOffice, 0, 3);
			instructorPane.add(txtOffice, 1, 3);
			instructorPane.add(lblDepartment, 0, 4);
			instructorPane.add(txtDept, 1, 4);
			instructorPane.add(lblInstrEmail, 0, 5);
			instructorPane.add(txtInstrEmail, 1, 5);
			instructorPane.add(btnAddInstructor, 1, 7);
	
			// Build Course Controls
			Label lblBuildCourse = new Label("Build a Course:");
			Label lblAddStudent2 = new Label("Add Student:");
			ComboBox<String> cboAddStudent = new ComboBox<>();
	
			cboAddStudent.getItems().addAll();
			Label lblToCourse = new Label("To Course:");
			ComboBox<String> cboToCourse = new ComboBox<>();
			cboToCourse.getItems().addAll();
			Label lblNewInstructor = new Label("New Instructor?   ");
			CheckBox ckbNewInstructor = new CheckBox();
	
			Label lblInstructorIs = new Label("Instructor Is:");
			ComboBox<String> cboAddStudent2 = new ComboBox<>();
			cboAddStudent2.getItems().addAll();
	
			cboAddStudent2.setDisable(true);
			ckbNewInstructor.selectedProperty().addListener(new ChangeListener<Boolean>() {
	
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (ckbNewInstructor.isSelected()) {
						cboAddStudent2.setDisable(false);
						System.out.println("is_selected");
					} else {
						cboAddStudent2.setDisable(true);
	
					}
				}
			});
	
			Button btnUpdateCourse = new Button("Update Course ->");
			btnUpdateCourse.setStyle(
					"-fx-font-size:12px;-fx-font-weight: bold;-fx-text-fill:#5E34B1;-fx-background-color:#b8b894;");
	
			// Create and set build course pane
			GridPane buildCoursePane = new GridPane();
			// buildCoursePane.setAlignment(Pos.CENTER);
			buildCoursePane.add(lblBuildCourse, 0, 0);
			buildCoursePane.add(lblAddStudent2, 0, 1);
			buildCoursePane.add(cboAddStudent, 1, 1);
			buildCoursePane.add(lblToCourse, 0, 2);
			buildCoursePane.add(cboToCourse, 1, 2);
			buildCoursePane.add(ckbNewInstructor, 0, 3);
			buildCoursePane.add(lblNewInstructor, 1, 3);
	//		lblNewInstructor.setPadding(new Insets(15,15,15,15));
	
			buildCoursePane.add(lblInstructorIs, 0, 4);
			buildCoursePane.add(cboAddStudent2, 1, 4);
			buildCoursePane.add(btnUpdateCourse, 1, 5);
			// buildCoursePane.setHalignment(ckbNewInstructor, HPos.RIGHT);
	
			// Build Text Controls
			GridPane textPane = new GridPane();
			txtTextPane = new TextArea();
	
			// Create and set text pane
			txtTextPane.setMaxWidth(800);
			textPane.add(txtTextPane, 0, 0);
	
			// Create and set primary pane
			GridPane primaryPane = new GridPane();
			primaryPane.setPadding(new Insets(15, 15, 15, 15));
			primaryPane.setHgap(15);
			primaryPane.setVgap(15);
			primaryPane.add(studentPane, 0, 0);
			primaryPane.add(coursePane, 1, 0);
			primaryPane.add(instructorPane, 2, 0);
			primaryPane.add(buildCoursePane, 0, 2);
			primaryPane.add(textPane, 1, 2, 3, 2);
			primaryPane.setStyle(
					"-fx-background-image: url(\"https://img.freepik.com/free-vector/shiny-blue-blurred-background_1034-804.jpg\")");
			// Build our Scene
			Scene primaryScene = new Scene(primaryPane, 850, 425);
	
			// Set our Stage
			primaryStage.setScene(primaryScene);
			primaryStage.setTitle("SMS App");
			primaryStage.show();
	
		}
	
		public static void main(String[] args) {
			launch(args);
		}
	
		@Override
		public void handle(ActionEvent e) {
			if (e.getSource() == btnAddStudent) {
				// write code here
				Student s = new Student(null, 0, null, 0.0, null);
				s.setName(txtStudentName.getText());
				s.setStudentYear(cboYear.getSelectionModel().getSelectedIndex());
				s.setStudentMajor(txtMajor.getText());
				s.setGPA(Double.parseDouble(txtGPA.getText()));
				s.setStudentEmail(txtEmail.getText());
				students.add(s);
				txtTextPane.setText(s.toString());
				System.out.println(s.toString());
				System.out.println("add student clicked");
	
			} else if (e.getSource() == btnAddCourse) {
	
				Course c = new Course(null, null, null, 0);
				c.setCourseName(txtCourseName.getText());
				c.setCourseBldgRoom(txtRoom.getText());
				c.setCourseBuilding(cboBuilding.getSelectionModel().getSelectedItem().toString());
				c.setCapacity(Integer.parseInt(txtMaxCap.getText()));
				// add this course to the courses arraylist
				courses.add(c);
				txtTextPane.setText(c.toString());
				System.out.println(c.toString());
	
			} else if (e.getSource() == btnAddInstructor) {
	//                    Instructor i = new Instructor(null, null, null, null, null);
	//                    i.setName(txtInstructorName.getText());
	//                    i.setPrefix((cboPrefix.getSelectionModel().getSelectedItem().toString()));
	//                    i.setOfficeLocation(txtOffice.getText());
	//                    i.setDepartment(txtDept.getText());
	//                    i.setEmail(txtInstrEmail.getText());
	//                    instructors.add(i);
	//                    txtTextPane.setText(i.toString());
	//                    System.out.println(i.toString());
	
			}
	
		}
	
	}
