package control;

import java.util.HashMap;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dataaccess.DataAccess;
import model.dataaccess.DataAccessFacade;
import model.domain.User;
import util.Util;

public class LoginController extends Application {
	private boolean userOrIdWrong=true;
	
	private MainController secondWindow;
	private Stage primaryStage;

	
	
	@Override
	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;

		
		Parent root = FXMLLoader.load(getClass().getResource("/view/templates/login.fxml"));

		stage.setTitle("Welcome MUM Library");
		stage.setScene(new Scene(root));

		TextField userId = (TextField) root.lookup("#userId");
		TextField txtPassword = (TextField) root.lookup("#txtPassword");

		Button button = (Button) root.lookup("#btnLogin");
		
		System.out.println(root.lookup("#btnLogin"));

		button.setOnAction((event) -> {

			DataAccess db = new DataAccessFacade();
			HashMap<String, User> users = db.readUserMap();
			for (Entry<String, User> entry : users.entrySet()) {
				String key = entry.getKey();
				User user = entry.getValue();
				if (user.authenticate(userId.getText() , txtPassword.getText()))
				{
					System.out.println("ok");
					userOrIdWrong=false;
					secondWindow = new MainController(user);
					
					try {
						secondWindow.start(this.primaryStage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  


					
				}

			}
			if (userOrIdWrong)
			{
				Util.showAlert("User id or password Wrong ", "Error login", AlertType.ERROR);
			}

			

		});

		stage.show();

	}

	public static void main(String[] args) {
		
		Application.launch(LoginController.class, args);
	}

}