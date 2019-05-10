
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Pizza extends Application {
	int sel_size = -1;
	int plain_status = 0;
	int sausage_status = 0;
	int mushroom_status = 0;
	int peperoni_status = 0;
	private Text txtPrice;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// set title
		primaryStage.setTitle("");

		// root component(or layer)
		VBox root = new VBox();

		// add the header
		Text top_header = new Text(10, 0, "Pizza Price Calculator");
		// make it bigger
		top_header.setFont(Font.font("Verdana", FontPosture.REGULAR, 18));
		top_header.setTextAlignment(TextAlignment.CENTER);

		Text second_header = new Text("Pizza Size: ");
		second_header.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));

		RadioButton small = new RadioButton("Small");
		RadioButton medium = new RadioButton("Medium");
		RadioButton large = new RadioButton("Large");

		Text third_header = new Text("Pizza Toppings: ");
		third_header.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));

		CheckBox plain = new CheckBox("Plain");
		CheckBox sausage = new CheckBox("Sausage");
		CheckBox mushroom = new CheckBox("Mushroom");
		CheckBox pepperoni = new CheckBox("Pepperoni");

		// add the gridpane
		GridPane gp = new GridPane();

		// set its size
		// gp.setPrefSize(320, 200);

		// set vertical and horizontal gap
		gp.setVgap(10);
		gp.setHgap(10);

		// it spans over three columns
		gp.add(second_header, 0, 0, 3, 1);
		// add radio buttons on 1st row
		// they take separate columns
		gp.add(small, 1, 1, 1, 1);
		gp.add(medium, 2, 1, 1, 1);
		gp.add(large, 3, 1, 1, 1);

		small.setUserData("0");
		medium.setUserData("1");
		large.setUserData("2");

		final ToggleGroup sizeGroup = new ToggleGroup();
		small.setToggleGroup(sizeGroup);
		medium.setToggleGroup(sizeGroup);
		large.setToggleGroup(sizeGroup);

		// add third header on 0th row
		// it spans over three columns
		gp.add(third_header, 0, 2, 3, 1);
		// add radio buttons on 1st row
		// they take separate columns
		gp.add(plain, 1, 3, 1, 1);
		gp.add(sausage, 2, 3, 1, 1);
		gp.add(mushroom, 3, 3, 1, 1);
		gp.add(pepperoni, 4, 3, 1, 1);

		// price label
		Text price_label = new Text("Price: ");
		price_label.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
		gp.add(price_label, 0, 4, 1, 1);
		// price
		txtPrice = new Text("$");
		txtPrice.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
		gp.add(txtPrice, 1, 4, 1, 1);

		root.getChildren().add(top_header);
		root.getChildren().add(gp);

		plain.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected,
					Boolean isNowSelected) {
				if (isNowSelected) {
					plain_status = 1;
					sausage.setSelected(false);
					mushroom.setSelected(false);
					pepperoni.setSelected(false);

				} else {
					plain_status = 0;
				}
				txtPrice.setText("$ "+ calculatePrice());

			}
		});

		sausage.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected,
					Boolean isNowSelected) {
				if (isNowSelected) {
					sausage_status = 1;
					plain.setSelected(false);

				} else {
					sausage_status = 0;
				}
				txtPrice.setText("$ "+ calculatePrice());

			}
		});

		mushroom.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected,
					Boolean isNowSelected) {
				if (isNowSelected) {
					mushroom_status = 1;
					plain.setSelected(false);

				} else {
					mushroom_status = 0;
				}
				txtPrice.setText("$ "+ calculatePrice());

			}
		});

		pepperoni.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected,
					Boolean isNowSelected) {
				if (isNowSelected) {
					peperoni_status = 1;
					plain.setSelected(false);

				} else {
					peperoni_status = 0;
				}
				txtPrice.setText("$ "+ calculatePrice());

			}
		});

		sizeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (sizeGroup.getSelectedToggle() != null) {
					sel_size = Integer.parseInt(sizeGroup.getSelectedToggle().getUserData().toString());
					txtPrice.setText("$ "+ calculatePrice());
					//System.out.println(sel_size);
				}
			}
		});

		// create scene object
		Scene sc = new Scene(root, 400, 200);
		primaryStage.setScene(sc);
		primaryStage.show();
	}

	
	public double calculatePrice()
	{
	    
	    double price = 0.0;
	    int topping = sausage_status + mushroom_status + peperoni_status;
	    switch(sel_size)
	    {
	        case 0: price = 5 + (topping * 0.50) ;break;
	        case 1: price = 8 + (topping * 1.00) ;break;
	        case 2: price = 11.5 + (topping * 1.75 ) ;break;
	        default: System.out.println("Size not selected");break;
	    }
	    
	    return price;
	}
	
	
	
	public static void main(String[] args) {
		launch(args);

	}
	
	
	

}
