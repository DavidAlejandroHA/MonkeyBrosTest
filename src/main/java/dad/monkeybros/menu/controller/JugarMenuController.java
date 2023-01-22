package dad.monkeybros.menu.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.monkeybros.MonkeyBrosApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

// Gestión de la escena del menú de Juego
public class JugarMenuController implements Initializable {
	// view
	
	@FXML
	private ImageView menuAtrasPrincipal;

	@FXML
	private ImageView menuCargarPartida;
	
	private BorderPane anteriorView;

	@FXML
	private BorderPane view;
	
	private ColorAdjust colorAdjust = new ColorAdjust();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		menuCargarPartida.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			// onCargarPartidaClickAction();
		});
		// https://www.youtube.com/watch?v=aOcow70vqb4
		
		colorAdjust.setBrightness(-0.5);
		gestionarEfectos();

		// Gestión de los efectos de los botones
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
	
	public void gestionarEfectos() {
		
		oscurecerEvent(menuCargarPartida);
		oscurecerEvent(menuAtrasPrincipal);
	}
	
	public void oscurecerEvent(ImageView imgV) {
		// https://stackoverflow.com/questions/33807122/change-brightness-of-image-with-javafx
		imgV.addEventFilter(MouseEvent.MOUSE_ENTERED, e -> {
			imgV.setEffect(colorAdjust);
		});

		imgV.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
			imgV.setEffect(null);
		});
	}

	public ImageView getMenuAtrasPrincipal() {
		return menuAtrasPrincipal;
	}

	public ImageView getMenuCargarPartida() {
		return menuCargarPartida;
	}

	/*
	 * void onCargarPartidaClickAction() { BorderPane cargarPartidaView = new
	 * BorderPane();
	 * 
	 * juegoImagenTest = new
	 * Image(MonkeyBrosApp.class.getResourceAsStream("/images/juegoImagenTest.png"))
	 * ; BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
	 * BackgroundSize.AUTO, false, false, true, true); backgroundJuegoImagenTest =
	 * new Background(new BackgroundImage(juegoImagenTest,
	 * BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
	 * BackgroundPosition.CENTER, size));
	 * 
	 * cargarPartidaView.setBackground(backgroundJuegoImagenTest);
	 * 
	 * //escenaApp = MonkeyBrosApp.scene; MonkeyBrosApp.primaryStage.setScene(new
	 * Scene(cargarPartidaView, juegoImagenTest.getWidth(),
	 * juegoImagenTest.getHeight())); MonkeyBrosApp.primaryStage.centerOnScreen(); }
	 */
	public BorderPane getAnteriorView() {
		return anteriorView;
	}

	public void setAnteriorView(BorderPane anteriorView) {
		this.anteriorView = anteriorView;
	}

	public BorderPane getView() {
		return view;
	}

	@FXML
	void onAtrasClickAction(MouseEvent event) {
		MonkeyBrosApp.scene.setRoot(anteriorView);
	}

	@FXML
	void onCargarClickAction(MouseEvent event) {

	}

}
