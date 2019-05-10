package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.application.Application;

public class MainController extends Application {

	// declare four variables 
	// stores the clicked operator
	int choice = 0;
	// stores the first operand
	double num1 = 0;
	// stores the second operand
	double num2 = 0;
	// stores the result
	double result = 0;

	@FXML
	private TextField txtOutput;
	@FXML
	private Button btn1;
	@FXML
	private Button btn6;
	@FXML
	private Button btn4;
	@FXML
	private Button btnC;
	@FXML
	private Button btn8;
	@FXML
	private Button btn7;
	@FXML
	private Button btn5;
	@FXML
	private Button btn9;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btnPlus;
	@FXML
	private Button btnEquals;
	@FXML
	private Button btnDivide;
	@FXML
	private Button btn0;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calculator");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setMaxWidth(1200);
			primaryStage.setMaxHeight(600);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Event Listener on Button[#btn1].onAction
	@FXML
	public void buttonClicked(ActionEvent event) {

		// if a number is clicked append it to the existing
		// number in the output textfield
		String curr_value;
		if (event.getSource() == btn0) {
			// append number
			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "0");
		}

		else if (event.getSource() == btn1) {
			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "1");

		}

		else if (event.getSource() == btn2) {

			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "2");
		}

		else if (event.getSource() == btn3) {
			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "3");

		}

		else if (event.getSource() == btn4) {

			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "4");
		}

		else if (event.getSource() == btn5) {

			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "5");
		}

		else if (event.getSource() == btn6) {
			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "6");

		}

		else if (event.getSource() == btn7) {

			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "7");
		}

		else if (event.getSource() == btn8) {

			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "8");
		}

		else if (event.getSource() == btn9) {

			curr_value = txtOutput.getText();
			txtOutput.setText(curr_value + "9");
		}

		else if (event.getSource() == btnPlus) {
			  // set choice to 1
            choice = 1;
            // if the textfield is not empty
            if (txtOutput.getText().length() > 0)
            {
                // get the string and convert it to double
            	// and assign it to num1
                num1 = Double.parseDouble(txtOutput.getText());
                // convert it to double
            }
            // clear the text field
            txtOutput.clear();

		}

		else if (event.getSource() == btnDivide) {
			
			  // set choice to 1
            choice = 2;
            // if the textfield is not empty
            if (txtOutput.getText().length() > 0)
            {
                // get the string and convert it to double
            	// and assign it to num1
                num1 = Double.parseDouble(txtOutput.getText());
                // convert it to double
            }
            // clear the text field
            txtOutput.clear();

		}

		else if (event.getSource() == btnEquals) {

			 //Error Handling: Make sure the textfield is not empty
            if (txtOutput.getText().length() > 0)
            {
                num2 = Double.parseDouble(txtOutput.getText());

                // clear the text field
                txtOutput.clear();            
             }

            // depending on choice
            switch (choice)
            {
                // if choicd is 1
                case 1:
                    //add the numbers and store it in result
                    result = num1 + num2;
                    // change the textfield content
                    // I added "" to convert result to string
                    txtOutput.setText(result + "");
                    break;
                // if choice 2
                case 2:
                	//divide num1 by num2 and store it in result
                    result = num1 / num2;
                    // change the textfield content
                    // I added "" to convert result to string
                    txtOutput.setText(result + "");
                    break;
 
                // if choice is unknown reset the variables
                default:
                    //reset everything
                    txtOutput.clear();
                    num1 = 0;
                    num2 = 0;
                    result = 0;
                    choice = 0;
                    break;
            }
		}

		// when clear is clicked. remove whatever is in the
		// textbox and reset the four variables
		else if (event.getSource() == btnC) {
			choice = 0;
			num1 = 0;
			num2 = 0;
			txtOutput.clear();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
