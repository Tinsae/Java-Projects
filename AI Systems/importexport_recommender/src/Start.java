import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.connector.DataBaseConnector;
import jcolibri.exception.ExecutionException;

public class Start extends Application implements StandardCBRApplication {
	public static CBRCaseBase _theCases;
	Connector _connector;
	public static CBRCaseBase _caseBase;

	@FXML
	Button btnRetrieve;
	@FXML
	Button btnReuse;
	@FXML
	Button btnRevise;
	@FXML
	Button btnRetain;
	@FXML
	AnchorPane ancPaneContent;
	public static Query queryController;
	public static Reuse reuseController;
	public static Revise reviseController;
	public static Retain retainController;


	@Override
	public void configure() throws ExecutionException {
		try {
			// Create a database connector
			_connector = new DataBaseConnector();
			// Initialize the DB connector with the configuration file
			_connector.initFromXMLfile(jcolibri.util.FileIO.findFile("databaseconfig.xml"));
			// Create a Lineal case base for in-memory organization
			_caseBase = new LinealCaseBase();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExecutionException(e);
		}

	}

	@Override
	public CBRCaseBase preCycle() throws ExecutionException {
		// Load cases from connector into the case base
		_caseBase.init(_connector);
		// System.out.println("connector is" + _connector);
		// Print the cases
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		 System.out.println(cases.size() + " found");
		for (CBRCase c : cases)
			System.out.println(c);
		return _caseBase;

	}

	@Override
	public void cycle(CBRQuery arg0) throws ExecutionException {
		// cycle is done 
		// in the Query.java and Result.java for Reterival
		
	}

	@Override
	public void postCycle() throws ExecutionException {

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CBR");
		primaryStage.setMaxWidth(1200);
		primaryStage.setMaxHeight(600);
		primaryStage.show();
	}

	
	public void cycleButtonClicked(ActionEvent ev)
	{
		try {
			if(ev.getSource().equals(btnRetrieve))
			{
			
				FXMLLoader loader = new FXMLLoader(getClass().getResource("query.fxml"));
				Pane retrieval = (Pane)loader.load();
				ancPaneContent.getChildren().clear();
			    queryController =loader.getController();
				ancPaneContent.getChildren().add(retrieval);
				}
			
			else if(ev.getSource().equals(btnReuse))

			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("reuse.fxml"));
				Pane reuse = (Pane)loader.load();
				ancPaneContent.getChildren().clear();
			    reuseController =loader.getController();
				ancPaneContent.getChildren().add(reuse);
			}
			else if(ev.getSource().equals(btnRevise))
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("revise.fxml"));
				Pane revise = (Pane)loader.load();
				ancPaneContent.getChildren().clear();
			    reviseController =loader.getController();
				ancPaneContent.getChildren().add(revise);
			}
			
			else if(ev.getSource().equals(btnRetain))
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("retain.fxml"));
				Pane retain = (Pane)loader.load();
				ancPaneContent.getChildren().clear();
			    retainController =loader.getController();
				ancPaneContent.getChildren().add(retain);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Start s = new Start();
		try {
			s.configure();
			_theCases = s.preCycle();
			
			
			

		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		launch(args);

	}

	
	
	
	
}
