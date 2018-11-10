import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import jcolibri.cbrcore.CBRCase;
import jcolibri.method.retrieve.RetrievalResult;
public class Revise extends VBox implements Initializable {

		
	@FXML
	TextField txtVNationality;
	@FXML
	TextField txtVLegalStatus;
	@FXML
	TextField txtVLocation;
	@FXML
	TextArea txtVGroup;
	@FXML
	TextArea txtVSubGroup;
	@FXML
	TextField txtVDescription;
	@FXML
	TextField txtVCapital;
	
	
	
	@FXML
	Accordion fullAccordion;
	@FXML
	TitledPane titledPaneDesc;
	@FXML
	TitledPane titledPaneSol;
 ArrayList<RetrievalResult> cases;
	
 
 CBRCase revisedCase;
 
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		fullAccordion.setExpandedPane(titledPaneDesc);
		
		if(Query.resultController == null)
		{
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Solution not found");
			a.setContentText("You need get solution first");
			a.showAndWait();

		}
		else
		{
			cases = Query.resultController.cases;
			RetrievalResult rr = cases.get(0);		
			revisedCase = rr.get_case();
			showCase();
		}
		
	}
	
	public void wantToSendRevision(ActionEvent e)
	{
		IECaseDescription desc = (IECaseDescription) revisedCase.getDescription();
		IECaseSolution sol = (IECaseSolution) revisedCase.getSolution();
		
		desc.setNationality(txtVNationality.getText());
		desc.setLegalStatus(txtVLegalStatus.getText());
		desc.setLocation(txtVLocation.getText());
		desc.setGroup(txtVGroup.getText());
		desc.setSubGroup(txtVSubGroup.getText());
		
		sol.setCapital(Long.parseLong(txtVCapital.getText()));
		sol.setDescription(txtVDescription.getText());
		
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Ready");
		a.setContentText("Revision is ready to be saved; go to retain");
		a.showAndWait();

		
		
	}
	
	
	void showCase() {
		
		IECaseDescription desc = (IECaseDescription) revisedCase.getDescription();
		
		if(!desc.equals(null))
		{

		txtVNationality.setText(desc.getNationality());
		txtVLegalStatus.setText(desc.getLegalStatus());
		txtVLocation.setText(desc.getLocation());
		txtVGroup.setText(desc.getGroup());
		txtVSubGroup.setText(desc.getSubGroup());
		}
		else
		{
			System.out.println("No Descripition");

		}
		IECaseSolution sol = (IECaseSolution) revisedCase.getSolution();
		if (sol.equals(null))
		{
			System.out.println("No Solution");
		}
		else
		{
			txtVDescription.setText(sol.getDescription());
			txtVCapital.setText(sol.getCapital().toString());
		}
		
	}


}
