package dad.monkeybros;

import dad.monkeybros.menu.controller.RootMenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonkeyBrosApp extends Application {

	public static Stage primaryStage;
	public static Scene scene;
	
	private RootMenuController controller = new RootMenuController();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		MonkeyBrosApp.primaryStage = primaryStage;
		
		scene = new Scene(controller.getView());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("MonkeyBros");
		// primaryStage.getIcons().add(new
		// Image(MonkeyBrosApp.class.getResourceAsStream("/images/calendar-16x16.png")));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
