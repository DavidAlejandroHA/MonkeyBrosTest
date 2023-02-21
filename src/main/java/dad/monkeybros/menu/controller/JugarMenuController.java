package dad.monkeybros.menu.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.monkeybros.MonkeyBrosApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

// Gestión de la escena del menú de Juego
public class JugarMenuController implements Initializable {
	// view

	@FXML
	private Button menuAtrasBoton;

	@FXML
	private Button menuCargarPartidaBoton;
	
	@FXML
	private VBox menuOpcionesVBox;

	private BorderPane anteriorView;

	@FXML
	private BorderPane view;
	
	// controller
	
	//private OpcionesMenuController opcionesMenuController = new OpcionesMenuController();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// https://www.youtube.com/watch?v=aOcow70vqb4
		
	}

	public JugarMenuController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menus/MenuJugarView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BorderPane getAnteriorView() {
		return anteriorView;
	}

	public void setAnteriorView(BorderPane anteriorView) {
		this.anteriorView = anteriorView;
	}
	
	public VBox getMenuOpcionesVBox() {
		return menuOpcionesVBox;
	}

	public BorderPane getView() {
		return view;
	}

	@FXML
	void onAtrasClickAction(MouseEvent event) {
		MonkeyBrosApp.scene.setRoot(anteriorView);
	}

	@FXML
	void onCargarPartidaClickAction(MouseEvent event) {
		//opcionesMenuController.setAnteriorView(view);
		//MonkeyBrosApp.scene.setRoot(opcionesMenuController.getView());
	}

}
