import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import jcolibri.cbrcore.CBRCase;

public class Reuse extends VBox implements Initializable{

	@FXML
	VBox myVBox ;
	@FXML
	Text txtRecomDesc;
	@FXML
	Text txtRecomCapital;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(Query.resultController == null)
		{
			//These can not be done because reuse is not fully initalized;
			//Start.reuseController.txtRecomCapital.setStyle("-fx-text-fill:red;");
			//Start.reuseController.txtRecomDesc.setStyle("-fx-text-fill:red;");

			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("No Cases Loaded");
			a.setContentText("You need to retrive case first");
			a.showAndWait();
		}
		else
		{
			CBRCase _theCase = Query.resultController.cases.get(0).get_case();
			IECaseSolution sol = (IECaseSolution)_theCase.getSolution();
			txtRecomDesc.setText(sol.description);
			txtRecomCapital.setText(sol.getCapital().toString());
		}
				
	}
	
}
