package dad.monkeybros.menu.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import dad.monkeybros.MonkeyBrosApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RootMenuController implements Initializable {

	// view
	@FXML
	private BorderPane view;

	@FXML
	private Button menuJugarBoton;

	@FXML
	private Button menuMultijugadorBoton;

	@FXML
	private Button menuOpcionesBoton;

	@FXML
	private Button menuSalirBoton;

	@FXML
	private ImageView menuTitulo;

	@FXML
	private VBox menuOpcionesVBox;

	private Image imagenBackground;

	private Background background;

	private Image imagenBoton;

	private Image imagenBotonOscuro;

	// model

	private JugarMenuController jugarController = new JugarMenuController();

	// private ColorAdjust colorAdjust = new ColorAdjust();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Cargar imágenes

		imagenBoton = new Image(MonkeyBrosApp.class.getResourceAsStream("/images/menu/MenuBotonMonkeyBros.png"), 480.0,
				160.0, false, false);

		imagenBotonOscuro = new Image(
				MonkeyBrosApp.class.getResourceAsStream("/images/menu/MenuBotonMonkeyBrosOscuro.png"), 480.0, 160.0,
				false, false);

		// Añadir fuentes a la vista

		view.getStylesheets().add(getClass().getResource("/css/MainTheme.css").toExternalForm());

		// Gestión del fondo
		imagenBackground = new Image(MonkeyBrosApp.class.getResourceAsStream("/images/MonkeyBrosMenuBackground.png"));

		BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);

		background = new Background(new BackgroundImage(imagenBackground, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));

		// -- Poner al menú y a las demás vistas del menú el mismo fondo
		view.setBackground(background);
		jugarController.getView().setBackground(background);

		// colorAdjust.setBrightness(-0.5);
		gestionarBotones();

	}

	public RootMenuController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menus/MenuPrincipalView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BorderPane getView() {
		return view;
	}

	public void setView(BorderPane view) {
		this.view = view;
	}

	public void gestionarBotones() {
		List<Button> listaDiasLabels = menuOpcionesVBox.getChildren().stream().filter(node -> node instanceof Button)
				.map(node -> (Button) node).filter(boton -> "botonMenu".equals(boton.getId()))
				.collect(Collectors.toList());
		for (int i = 0; i < listaDiasLabels.size(); i++) {
			anadirBackgroundBoton(listaDiasLabels.get(i));
		}
	}

	public void anadirBackgroundBoton(Button b) {
		BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true,
				true);
		Background background = new Background(new BackgroundImage(imagenBoton, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize));
		Background backgroundDark = new Background(new BackgroundImage(imagenBotonOscuro, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize));
		b.setBackground(background);

		b.addEventFilter(MouseEvent.MOUSE_ENTERED, e -> {
			b.setBackground(backgroundDark);
			//imgV.setEffect(colorAdjust);
		});

		b.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
			b.setBackground(background);
		});
	}

	// Cambiar al menu de jugar
	@FXML
	void onJugarClickAction(MouseEvent event) throws IOException {
		// MonkeyBrosApp.primaryStage.setScene(new Scene(jugarView,
		// escenaApp.getWidth(), escenaApp.getHeight()));*/

		jugarController.setAnteriorView(view);
		MonkeyBrosApp.scene.setRoot(jugarController.getView());

		// https://stackoverflow.com/questions/37106379/why-doesnt-my-scene-pop-up-when-changing-scenes-javafx
	}

	// Cambiar al menu de Multijugador
	@FXML
	void onMultijugadorClickAction(MouseEvent event) {

	}

	// Cambiar al menu de opciones
	@FXML
	void onOpcionesClickAction(MouseEvent event) {
		
	}

	// Salir del juego
	@FXML
	void onSalirClickAction(MouseEvent event) {

	}

}
