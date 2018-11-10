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
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import jcolibri.cbrcore.CBRCase;
import jcolibri.method.retrieve.RetrievalResult;
public class Result extends VBox implements Initializable {

	private Collection<CBRCase> selectedCases;
	private Collection<RetrievalResult> eval;
	public ArrayList<RetrievalResult> cases;
	private int currentCase;

	
	@FXML
	Text txtRNationality;
	@FXML
	Text txtRLegalStatus;
	@FXML
	Text txtRLocation;
	@FXML
	TextArea txtRGroup;
	@FXML
	TextArea txtRSubGroup;
	@FXML
	Text txtRDescription;
	@FXML
	Text txtRCapital;
	@FXML
	Label txtRCaseNo;
	
	@FXML
	Button btnPrev;
	
	@FXML
	Button btnNext;
	
	@FXML
	Accordion fullAccordion;
	@FXML
	TitledPane titledPaneDesc;
	@FXML
	TitledPane titledPaneSol;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cases = new ArrayList<RetrievalResult>();
		fullAccordion.setExpandedPane(titledPaneDesc);
		
		selectedCases = Start.queryController.selectedcases;
		eval =Start.queryController.eval;
		if(!(selectedCases.equals(null) && eval.equals(null)))
		{
			showCases(eval,selectedCases);	
		}	
		else
		{
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("Invalid Input");
			a.setHeaderText("Number Format Exception");
			a.setContentText("Give query first");
			a.showAndWait();
			
		}
		
	}
	
	
	public void backAndForth(ActionEvent ee)
	{
		if(ee.getSource().equals(btnPrev))
		{
			currentCase = (currentCase + cases.size() - 1) % cases.size();
			showCase();
			
		}
		else if(ee.getSource().equals(btnNext))
		{
			
			currentCase = (currentCase + 1) % cases.size();
			showCase();

		}
		else 
		{
			System.out.println("Illegal event");
		}
		
		
	}
	
	public void showCases(Collection<RetrievalResult> eval, Collection<CBRCase> selected) {

		cases.clear();
		for (RetrievalResult rr : eval)
			if (selected.contains(rr.get_case()))
				cases.add(rr);
		currentCase = 0;
		showCase();
	
	}

	void showCase() {
		System.out.println("Current case: "+currentCase);
		RetrievalResult rr = cases.get(currentCase);
		Double sim = rr.getEval();
		DecimalFormat two = new DecimalFormat("#0.00");
		

		CBRCase _case = rr.get_case();
		txtRCaseNo.setText(_case.getID().toString() 
				+ " -> " + two.format(sim) + " (" + (currentCase + 1)
				+ "of" + cases.size() + ")");

		IECaseDescription desc = (IECaseDescription) _case.getDescription();
		
		if(!desc.equals(null))
		{
		System.out.println(desc.toString());

		txtRNationality.setText(desc.getNationality());
		txtRLegalStatus.setText(desc.getLegalStatus());
		txtRLocation.setText(desc.getLocation());
		txtRGroup.setText(desc.getGroup());
		txtRSubGroup.setText(desc.getSubGroup());
		}
		else
		{
			System.out.println("No Descripition");

		}
		IECaseSolution sol = (IECaseSolution) _case.getSolution();
		if (sol.equals(null))
		{
			System.out.println("No Solution");
		}
		else
		{
			System.out.println(sol.toString());
			txtRDescription.setText(sol.getDescription());
			txtRCapital.setText(sol.getCapital().toString());
		}
		
	}


}
