package View;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Application.*;
import Classes.*;

public class HotelController implements ControlledScreen{

	@FXML
	private Label HotelNameLabel;
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

	private MainController main;


	@FXML
	private void initialize() {
		showHotelDetails(HotelEditController.Hotel);
	}

	public void setScreenParent(MainController screenParent){
		main = screenParent;
	}
	
	

	private void showHotelDetails(Hotel Hotel) {
		if (Hotel != null) {

			HotelNameLabel.setText(Hotel.getHotelName());
			StarsLabel.setText(Hotel.getStars());
			PopularityLabel.setText(Hotel.getPopularity());
			DistanceLabel.setText(Hotel.getDistance());
			BreakfastLabel.setText(Hotel.getBreakfast());
			BarLabel.setText(Hotel.getBar());	 
			GymLabel.setText(Hotel.getGym());	
			PetsLabel.setText(Hotel.getPets());
		}else{

			HotelNameLabel.setText("");
			StarsLabel.setText("");
			PopularityLabel.setText("");
			DistanceLabel.setText("");
			BreakfastLabel.setText("");
			BarLabel.setText("");
			GymLabel.setText("");
			PoolLabel.setText("");
			PetsLabel.setText("");
		}
	}

	public HotelController() {
	}
}