package View;

import java.util.ArrayList;
import Application.App;
import Classes.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Database.*;

public class HotelCompareController implements ControlledScreen {
	
	
	private MainController main;
	
	

	@FXML
	private TableView<Hotel> HotelTable;
	@FXML
	private Button refresh;
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
	private ArrayList<Hotel> database = SQLiteJDBC.RetrieveHotels();
	@FXML
	private ObservableList<Hotel> outPutList =  FXCollections.observableArrayList(database);
	
	

	public void setScreenParent(MainController screenParent){
		main = screenParent;
	}
	@FXML
	private void goToAdmin(ActionEvent event){
		main.setScreen(App.HotelOverviewID);

	}
	@FXML
	private void goToCompare(ActionEvent event){
		main.setScreen(App.HotelCompareID);

	}

	@Override
	public void initialize() {
		if(!outPutList.isEmpty()){
		HotelTable.setItems(outPutList);
		HotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().HotelNameProperty());
		showHotelDetails(null);
		HotelTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showHotelDetails(newValue));
		System.out.println("HotelOutput initialized with content");
		}else{
			System.out.println("HotelOutput initialized without content");
		}
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
}