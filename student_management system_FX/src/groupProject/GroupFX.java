//fx
package groupProject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.shape.*;

import java.util.*;

public class GroupFX extends Application implements EventHandler<ActionEvent> {

	private Button btnAddStudent;
	private Button btnAddCourse;
	private Button btnAddInstructor;

	@Override
	public void start(Stage primaryStage) {

		// Heading labels for each section
		Label lblAddStudent = new Label("Add Student:");
		Label lblAddCourse = new Label("Add Course:");
		Label lblAddInstructor = new Label("Add Instructor:");
		Label lblBuildCourse = new Label("Build a Course");

		// Add Student labels and textboxes
		Label lblStudentName = new Label("Name:");
		Label lblStudentYear = new Label("Year:");
		Label lblStudentMajor = new Label("Major:");
		Label lblStudentGPA = new Label("GPA:");
		Label lblStudentEmail = new Label("Email:");
		TextField txtStudentName = new TextField();
		ComboBox studentYearDrop = new ComboBox();
		studentYearDrop.getItems().addAll("Freshman", "Sophomore", "Junior", "Senior");
		TextField txtStudentMajor = new TextField();
		TextField txtStudentGPA = new TextField();
		TextField txtStudentEmail = new TextField();
		btnAddStudent = new Button("Add Student ->");
		btnAddStudent.setOnAction(this);

		// Add Course labels and textboxes
		Label lblCourseName = new Label("Name:");
		Label lblCourseBuilding = new Label("Building");
		Label lblCourseRoom = new Label("Room:");
		Label lblCourseCapacity = new Label("Max Capacity");
		TextField txtCourseName = new TextField();
		ComboBox courseBuildingDrop = new ComboBox();
		courseBuildingDrop.getItems().addAll("Showker", "Chandler", "Burrus Hall");
		TextField txtCourseRoom = new TextField();
		TextField txtCourseCapacity = new TextField();
		btnAddCourse = new Button("Add Course ->");
		btnAddCourse.setOnAction(this);
		// btnAddCourse.setText("Add Course ->");

		// Add Instructor labels and textboxes
		Label lblInstructorName = new Label("Name:");
		Label lblInstructorPrefix = new Label("Prefix");
		Label lblInstructorOffice = new Label("Office:");
		Label lblInstructorDepartment = new Label("Department:");
		Label lblInstructorEmail = new Label("Email:");
		TextField txtInstructorName = new TextField();
		ComboBox instructorPrefix = new ComboBox();
		instructorPrefix.getItems().addAll("Dr.", "Ms.", "Mrs.", "Mr.");
		TextField txtInstructorOffice = new TextField();
		TextField txtInstructorDepartment = new TextField();
		TextField txtInstructorEmail = new TextField();
		btnAddInstructor = new Button("Add Instructor ->");
		btnAddInstructor.setOnAction(this);
		// Build a Course

		Label lblAddStudent2 = new Label("Add Student:");
		ComboBox comboAddStudent = new ComboBox();
		comboAddStudent.getItems().addAll("Student Names to go here");
		Label lblToCourse = new Label("To Course:");
		ComboBox comboAddCourse = new ComboBox();
		comboAddCourse.getItems().addAll("Course will go here");
		CheckBox cb = new CheckBox();
		cb.setText("New instructor?");
		Label lblBuildInstructor = new Label("Instructor is: ");
		ComboBox comboAddInstructor = new ComboBox();
		comboAddInstructor.getItems().addAll("Instructor names will go here");
		Button btnUpdateCourse = new Button("Update Course ->");

		TextArea txtOutput = new TextArea();

		// Create a Pane and add the controls to it
		GridPane primaryPane = new GridPane();
		primaryPane.setAlignment(Pos.CENTER);
		primaryPane.add(lblAddStudent, 100, 50);// use smaller #'s for col/row
		primaryPane.add(lblStudentName, 100, 150);
		primaryPane.add(txtStudentName, 150, 150);
		primaryPane.add(lblStudentYear, 100, 200);
		primaryPane.add(studentYearDrop, 150, 200);
		primaryPane.add(lblStudentMajor, 100, 250);
		primaryPane.add(txtStudentMajor, 150, 250);
		primaryPane.add(lblStudentGPA, 100, 300);
		primaryPane.add(txtStudentGPA, 150, 300);
		primaryPane.add(lblStudentEmail, 100, 350);
		primaryPane.add(txtStudentEmail, 150, 350);
		primaryPane.add(btnAddStudent, 150, 400);
		primaryPane.add(lblBuildCourse, 100, 450);
		primaryPane.add(lblAddStudent2, 100, 500);
		primaryPane.add(comboAddStudent, 150, 500);
		primaryPane.add(lblToCourse, 100, 550);
		primaryPane.add(comboAddCourse, 150, 550);
		primaryPane.add(cb, 100, 600);
		primaryPane.add(lblBuildInstructor, 100, 650);
		primaryPane.add(comboAddInstructor, 150, 650);
		primaryPane.add(btnUpdateCourse, 150, 700);

		primaryPane.add(lblAddCourse, 200, 50);
		primaryPane.add(lblCourseName, 200, 150);
		primaryPane.add(txtCourseName, 250, 150);
		primaryPane.add(lblCourseBuilding, 200, 200);
		primaryPane.add(courseBuildingDrop, 250, 200);
		primaryPane.add(lblCourseRoom, 200, 250);
		primaryPane.add(txtCourseRoom, 250, 250);
		primaryPane.add(lblCourseCapacity, 200, 300);
		primaryPane.add(txtCourseCapacity, 250, 300);
		primaryPane.add(btnAddCourse, 250, 350);

		primaryPane.add(lblAddInstructor, 300, 50);
		primaryPane.add(lblInstructorName, 300, 150);
		primaryPane.add(txtInstructorName, 350, 150);
		primaryPane.add(lblInstructorPrefix, 300, 200);
		primaryPane.add(instructorPrefix, 350, 200);
		primaryPane.add(lblInstructorOffice, 300, 250);
		primaryPane.add(txtInstructorOffice, 350, 250);
		primaryPane.add(lblInstructorDepartment, 300, 300);
		primaryPane.add(txtInstructorDepartment, 350, 300);
		primaryPane.add(lblInstructorEmail, 300, 350);
		primaryPane.add(txtInstructorEmail, 350, 350);
		primaryPane.add(btnAddInstructor, 350, 400);

		primaryPane.add(txtOutput, 500, 500);

		// Scene
		Scene primaryScene = new Scene(primaryPane, 1000, 500);

		// Set the stage
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("SMS App V.3");
		primaryStage.show();
		// StackPane root = new StackPane();
		// root.getChildren().add(btn);
		primaryStage.setScene(primaryScene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent e) {

		if (e.getSource() == btnAddStudent) {
//			
			
		}

		else if (e.getSource() == btnAddCourse) {
			System.out.println("add course");
		}

		else if (e.getSource() == btnAddInstructor) {
			System.out.println("add instructor");
		}

		else {
			System.out.println("other button clicked");

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
