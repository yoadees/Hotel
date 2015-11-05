package View;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;

import Application.*;
import Classes.*;
import Database.SQLiteJDBC;

public class HotelOverviewController implements  ControlledScreen{

	@FXML
	private TableView<Hotel> HotelTable;
	@FXML
	private TableColumn<Hotel, String> HotelNameColumn;
	@FXML
	private Label HotelNameLabel;
	@FXML
	private Label PriceLabel;
	@FXML
	private Label StarsLabel;
	@FXML
	private Label PopularityLabel;
	@FXML
	private Label DistanceLabel;
	@FXML
	private Label BreakfastLabel;
	@FXML
	private Label BarLabel;
	@FXML
	private Label GymLabel;
	@FXML
	private Label PetsLabel;
	@FXML
	private Label PoolLabel;
	@FXML
	private boolean okClicked = false;
	@FXML
	private Hotel HotelInOverview;
	
	private MainController main;
	
	private ArrayList<Hotel> database = SQLiteJDBC.RetrieveHotels();
	@FXML
	private ObservableList<Hotel> OverviewList =  FXCollections.observableArrayList(database);
	
	
	@Override
	public void initialize() {
		if(!OverviewList.isEmpty()){
		HotelTable.setItems(OverviewList);
		HotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().HotelNameProperty());
		showHotelDetails(null);
		HotelTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showHotelDetails(newValue));
		System.out.println("HotelOutput initialized with content");
		}else{
			System.out.println("HotelOutput initialized without content");
		}
	}
	
	
	public void setScreenParent(MainController screenParent){
		main = screenParent;
	}

	@FXML
	private void goToOutput(ActionEvent event){
		main.setScreen(App.HotelOutputID);
	}

	
	private void showHotelDetails(Hotel Hotel) {
		if (Hotel != null) {

			
			HotelNameLabel.setText(Hotel.getHotelName());
			StarsLabel.setText(Integer.toString(Hotel.getStars()));
			PopularityLabel.setText(Integer.toString(Hotel.getPopularity()));
			PriceLabel.setText(Double.toString(Hotel.getHotelPrice()));
			DistanceLabel.setText(Double.toString(Hotel.getDistance()));
			BreakfastLabel.setText(Boolean.toString(Hotel.getBreakfast()));
			BarLabel.setText(Boolean.toString(Hotel.getBar()));	 
			GymLabel.setText(Boolean.toString(Hotel.getGym()));	
			PetsLabel.setText(Boolean.toString(Hotel.getPets()));
			PoolLabel.setText(Boolean.toString(Hotel.getPool()));
		}else{

			HotelNameLabel.setText("");
			StarsLabel.setText(Integer.toString(0));
			PopularityLabel.setText(Integer.toString(0));
			PriceLabel.setText(Double.toString(0));
			DistanceLabel.setText(Double.toString(0));
			BreakfastLabel.setText(Boolean.toString(false));
			BarLabel.setText(Boolean.toString(false));	 
			GymLabel.setText(Boolean.toString(false));	
			PetsLabel.setText(Boolean.toString(false));
			PoolLabel.setText(Boolean.toString(false));
		}
	}
	

	@FXML
	private void handleNewHotel(ActionEvent event) {
		main.setScreen(App.HotelEditID);
	}

	@FXML
	private void GoToDeleteHotel(ActionEvent event) {
		int selectedIndex = HotelTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			HotelTable.getItems().remove(selectedIndex);

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(App.getPrimaryStage());
			alert.setTitle("No Hotel chosen");
			alert.setHeaderText("No Hotel Selected");
			alert.setContentText("Please select a Hotel in the Label.");
			alert.showAndWait();
		}
	}

	@FXML
	private void goToEditHotel(ActionEvent event){
		Hotel hotel = HotelTable.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			main.setScreen(App.HotelEditID);
			

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(App.getPrimaryStage());
			alert.setTitle("No Hotel chosen");
			alert.setHeaderText("No Hotel Selected");
			alert.setContentText("Please select a Hotel in the Label.");
			alert.showAndWait();
		}

	}
	
	
	public HotelOverviewController() {
	}
}