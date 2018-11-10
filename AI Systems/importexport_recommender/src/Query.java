import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;
import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import jcolibri.method.retrieve.selection.SelectCases;

public class Query extends VBox implements Initializable{


	@FXML
	Accordion fullAccordion;
	@FXML
	TitledPane queryTitledPane;
	@FXML
	TitledPane similarityTitledPane;
	@FXML
	ComboBox<String> cmbNationality;
	@FXML
	ComboBox<String> cmbLegalStatus;
	@FXML
	ComboBox<String> cmbLocation;
	@FXML
	TextArea txtGroup;
	@FXML
	TextArea txtSubGroup;
	@FXML
	Slider sliderNationality;
	@FXML
	Slider sliderLegalStatus;
	@FXML
	Slider sliderLocation;
	@FXML
	Slider sliderGroup;
	@FXML
	Slider sliderSubGroup;
	@FXML
	Spinner<Integer> spinnerTopK;
	@FXML
	VBox myVBox ;
		
	private  IECaseDescription desc;
	private  NNConfig config;
	private  CBRQuery query;
	public  Collection<CBRCase> selectedcases;
	public  Collection<RetrievalResult> eval;

	public static  Result resultController;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		fullAccordion.setExpandedPane(queryTitledPane);
		
		sliderNationality.setValue(1.0);;
		sliderLegalStatus.setValue(1.0);
		sliderLocation.setValue(1.0);
		sliderGroup.setValue(1.0);
		sliderSubGroup.setValue(1.0);
		
		
		//Fill the combo boxes

		String [] nationalities = {"Ethiopian","Austrian","American","Yemeni","Saudi","Indian",
				"Italian","Swedish","British","Lebanese","Australian","Israeli","German",
				"Kenyan","Turkish","Chinese","Greek","Sudanese","Canadian","Brazilian","Danish",
				"Dutch","Japanese"};
	
		String [] legal_status ={"IndividualMerchant","PrivateLimitedCompany",
		"CooperativeUnion","ShareCompany","CommercialRepresentative","GovernmentalOrganization"};
		String [] locations = {"AddisAbaba","Oromia","Amhara","DireDawa",
				"Tigray","Somalia","Hareri","BenishangulGumuz","SNNP","Gambela","Afar"};
		cmbNationality.getItems().clear();
		cmbNationality.setEditable(true);
		cmbNationality.getItems().addAll(nationalities);
		cmbNationality.getSelectionModel().select(3);
		cmbLegalStatus.getItems().clear();
		cmbLegalStatus.setEditable(true);
		cmbLegalStatus.getItems().addAll(legal_status);
		cmbLegalStatus.getSelectionModel().select(3);
		
		cmbLocation.getItems().clear();
		cmbLocation.setEditable(true);
		cmbLocation.getItems().addAll(locations);
		cmbLocation.getSelectionModel().select(3);

		spinnerTopK.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15));
		spinnerTopK.getValueFactory().setValue(10);
	
	}

	public void sendQueryClick(ActionEvent k)
	{
		
		//System.out.println("LS" +Start.queryController.cmbLegalStatus.getSelectionModel().getSelectedItem());
		// get query description
		desc = new IECaseDescription();
		desc.setNationality(cmbNationality.getSelectionModel().getSelectedItem().trim());
		desc.setLegalStatus(cmbLegalStatus.getSelectionModel().getSelectedItem().trim());
		desc.setLocation(cmbLocation.getSelectionModel().getSelectedItem().trim());
		desc.setGroup(txtGroup.getText().trim());
		desc.setSubGroup(txtSubGroup.getText().trim());
		query = new CBRQuery();
		query.setDescription(desc);	
		
		// get similarity configuration
		config = new NNConfig();
	    Attribute attribute;
	    LocalSimilarityFunction function;

		// add mapping of each attribute
        attribute = new Attribute("nationality", IECaseDescription.class);
        function = new Equal();
        config.addMapping(attribute, function);
        config.setWeight(attribute, sliderNationality.getValue());

        attribute = new Attribute("legalStatus", IECaseDescription.class);
        function = new Equal();
        config.addMapping(attribute, function);
        config.setWeight(attribute, sliderLegalStatus.getValue());

        attribute = new Attribute("location", IECaseDescription.class);
        function = new Equal();
        config.addMapping(attribute, function);
        config.setWeight(attribute, sliderLocation.getValue());
        
        attribute = new Attribute("group", IECaseDescription.class);
        function = new Equal();
        config.addMapping(attribute, function);
        config.setWeight(attribute, sliderGroup.getValue());
        
        attribute = new Attribute("subGroup", IECaseDescription.class);
        function = new Equal();
        config.addMapping(attribute, function);
        config.setWeight(attribute, sliderSubGroup.getValue());
        
        
        config.setDescriptionSimFunction(new Average());
		// Execute NN
		eval = NNScoringMethod.evaluateSimilarity(
				Start._theCases.getCases(), query, config);
		// Select k cases
		selectedcases = SelectCases.selectTopK(eval,
				spinnerTopK.getValue());
		
		
		// Change the scene in order to show the result
		
		AnchorPane ancPaneChild = (AnchorPane) myVBox.getParent();
		ancPaneChild.getChildren().clear();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
			Pane result =(Pane) loader.load();
			resultController = loader.getController();
			ancPaneChild.getChildren().clear();		
			ancPaneChild.getChildren().add(result);
		
		} catch (IOException e) {
			e.printStackTrace();
		}        
        
        
        
        
        
		
	}
	
	
	
}
