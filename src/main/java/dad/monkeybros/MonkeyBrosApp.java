package dad.monkeybros;

import java.util.Properties;

import dad.monkeybros.menu.controller.RootMenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonkeyBrosApp extends Application {

	public static Stage primaryStage;
	public static Scene scene;
	public static Properties properties;
	//public static ObjectProperty<Properties> props = new SimpleObjectProperty<>();
	
	private RootMenuController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		MonkeyBrosApp.primaryStage = primaryStage;
		// comentar esto*
		controller = new RootMenuController();
		scene = new Scene(controller.getView());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("MonkeyBros");
		primaryStage.setResizable(false);
		// primaryStage.getIcons().add(new
		// Image(MonkeyBrosApp.class.getResourceAsStream("/images/calendar-16x16.png")));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
