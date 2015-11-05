package View;

import java.util.HashMap;

import Application.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;



public class MainController extends StackPane{
	
	private HashMap<String, Node> screens = new HashMap<>();
	

	
	public MainController(){
		super();
	}

	public void addScreen(String name, Node screen){
		screens.put(name, screen);
	}

	public Node getScreen(String name){
		return screens.get(name);

	}
	public boolean loadScreen(String name, String resource){
		try {
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
			Parent loadscreen = (Parent) myLoader.load();
			ControlledScreen myScreenController = ((ControlledScreen) myLoader.getController());
			myScreenController.setScreenParent(this);
			addScreen(name, loadscreen);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage()+"Gick inte att ladda");
			return false;
		}
	}
	public boolean setScreen(final String name){
		if (screens.get(name)!= null){

			if (!getChildren().isEmpty()){
				getChildren().remove(0);
				getChildren().add(0, screens.get(name));


			} else {

				getChildren().add(screens.get(name));
			}
			return true;
		}else{
			System.out.println("Screen hasnt been loaded!");
			return false;
		}
	}
	public boolean unloadScreen(String name){
		if (screens.remove(name)== null){
			System.out.println("Screen didnt exist");
			return false;

		}else{ 
			return true;
		}
	}
}