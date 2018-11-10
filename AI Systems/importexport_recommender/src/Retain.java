import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import jcolibri.cbrcore.CBRCase;

public class Retain extends VBox implements Initializable{

	@FXML
	VBox myVBox ;
	
	@FXML
	Text txtNationality;
	@FXML
	Text txtLegalStatus;
	@FXML
	Text txtLocation;
	@FXML
	Text txtGroup;
	@FXML
	Text txtSubGroup;
	@FXML
	Text txtRecomDesc;
	@FXML
	Text txtRecomCapital;
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(Query.resultController == null || Start.reviseController == null)
		{
			

			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Problem");
			a.setContentText("Retrival or Revise is not done");
			a.showAndWait();
		}
		else
		{
			CBRCase _theCase = Start.reviseController.revisedCase;
			IECaseDescription desc = (IECaseDescription) _theCase.getDescription();
			IECaseSolution sol = (IECaseSolution)_theCase.getSolution();
			
			
			txtNationality.setText(desc.getNationality());
			txtLegalStatus.setText(desc.getLegalStatus());
			txtLocation.setText(desc.getLocation());
			txtGroup.setText(desc.getGroup());
			txtSubGroup.setText(desc.getSubGroup());
			
			txtRecomDesc.setText(sol.getDescription());
			txtRecomCapital.setText(sol.getCapital().toString());
		}
				
	}
	
	@SuppressWarnings("unchecked")
	public void saveClicked(ActionEvent ee)
	{
		ArrayList<CBRCase> casesToRetain = new ArrayList<CBRCase>();
		casesToRetain.clear();
		
		CBRCase revisedCase = Start.reviseController.revisedCase;
		IECaseDescription desc = (IECaseDescription) revisedCase.getDescription();
		IECaseSolution sol = (IECaseSolution) revisedCase.getSolution();

		Random rand = new Random();
		String genID = "ncase" +  (rand.nextInt(1000));
		desc.setCaseNo(genID);
		sol.setCaseNo(genID);
		
		
		// Start._caseBase.learnCases(casesToRetain2) ;
		MySql.init();
		PreparedStatement statement = null;
		String query = "INSERT INTO casebase VALUES(?,?,?,?,?,?,?,?)";
		try {
			statement = MySql.db.prepareStatement(query);
			statement.setString(1, genID);
			statement.setString(2, desc.getNationality());
			statement.setString(3, desc.getLegalStatus());
			statement.setString(4, desc.getLocation());
			statement.setString(5, desc.getGroup());
			statement.setString(6, desc.getSubGroup());
			statement.setString(7, sol.getDescription());
			statement.setLong(8, sol.getCapital());
			statement.executeUpdate();
			
			
			Start._theCases = Start._caseBase;
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		
		
		
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Finsihed");
		a.setHeaderText("A 4 Step CBR Cycle is Completed");
		a.setContentText("A new experience was learned and saved back to the casebase");

		a.showAndWait();
		
	}
	
}
