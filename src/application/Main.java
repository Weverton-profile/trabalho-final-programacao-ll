package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	private static Stage stage;
	
	private static Scene mainScene;
	private static Scene detailScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			
			primaryStage.setTitle("Weverton - Trabalho Final");
			
			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
			mainScene = new Scene(fxmlMain, 586, 582);
			
			Parent fxmlDetail = FXMLLoader.load(getClass().getResource("/gui/CarroList.fxml"));
			detailScene = new Scene(fxmlDetail, 849, 400);
			
			primaryStage.setScene(mainScene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void changeScreen(String scr) {
		switch(scr) {
		case "main":
			stage.setScene(mainScene);
			break;
		case "detail":
			stage.setScene(detailScene);
			break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
