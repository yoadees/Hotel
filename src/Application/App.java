package Application;


import Database.SQLiteJDBC;
import View.MainController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private static Stage primaryStage;
	public static String HotelOutputID = "HotelOutput";
	public static String HotelOutputFile = "HotelOutput.fxml";
	public static String HotelEditID = "HotelEdit";
	public static String HotelEditFile = "HotelEdit.fxml";
	public static String HotelOverviewID = "HotelOverview";
	public static String HotelOverviewFile = "HotelOverview.fxml";
	public static String HotelCompareID = "HotelCompare";
	public static String HotelCompareFile = "HotelCompare.fxml";


	
	@Override
	public void start(Stage primaryStage){
		SQLiteJDBC hello = new SQLiteJDBC();
		MainController mainContainer = new MainController();
		mainContainer.loadScreen(App.HotelOutputID,  App.HotelOutputFile);
		mainContainer.loadScreen(App.HotelOverviewID,  App.HotelOverviewFile);
		mainContainer.loadScreen(App.HotelEditID,  App.HotelEditFile);
		mainContainer.loadScreen(App.HotelCompareID,  App.HotelCompareFile);
		
		mainContainer.setScreen(App.HotelOutputID);
		
		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}



	

	
	
	public static void main(String[] args) {
		SQLiteJDBC hello = new SQLiteJDBC();
		hello.CompareHotels(1, 2);
		launch(args);
	}

}
