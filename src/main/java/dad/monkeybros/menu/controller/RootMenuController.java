package dad.monkeybros.menu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;

import dad.monkeybros.MonkeyBrosApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class RootMenuController implements Initializable {

	// model

//	private IntegerProperty loadedWidth = new SimpleIntegerProperty();
//	private IntegerProperty loadedHeight = new SimpleIntegerProperty();

	// view
	@FXML
	private BorderPane view;

	@FXML
	private Button menuJugarBoton;

	@FXML
	private Button menuHighscoreBoton;

	@FXML
	private Button menuOpcionesBoton;

	@FXML
	private Button menuSalirBoton;

	@FXML
	private ImageView menuTitulo;

	@FXML
	private VBox menuOpcionesVBox;

	// controllers

	private JugarMenuController jugarMenuController = new JugarMenuController();

	private OpcionesMenuController opcionesMenuController;

	private Properties properties = new Properties();
	// paths

	public static final File ruta_config_folder = new File(
			System.getProperty("user.home") + File.separator + "MonkeyBros" + File.separator + "configuracion");
	public static final String rutaFull = ruta_config_folder.getPath() + File.separator + "configuracion.props";

	// audio

	
	//MediaPlayer mediaplayer;
	
	//private static 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		//System.out.println(getClass().getResource("/audio/Bonus.mp3").toExternalForm());
		//System.out.println(Paths.get("test.mp3").toUri().toString());
//		//Media media = new Media(Paths.get("test.mp3").toUri().toString());
//		Media media = new Media("test.mp3");
//		System.out.println(media.getSource());
		
		//System.out.println(f.toURI());
		//mediaplayer = new MediaPlayer(new Media(f.toURI().toString()));  
		//mediaplayer.play();
		// System.out.println(getClass().getResource("/audio/Bonus Room Blitz Restored
		// to HD.mp3"));

		try {
			properties.load(new FileInputStream(RootMenuController.rutaFull));
			// System.out.println(java.awt.event.KeyEvent.getKeyText(' ')); // en mayus
			Resolucion res = Resolucion.valueOf(properties.getProperty("resolucion"));
			System.out.println(Resolucion.valueOf(properties.getProperty("resolucion")));

			// Cometar esto*
			MonkeyBrosApp.primaryStage.setWidth(res.getWidth());
			MonkeyBrosApp.primaryStage.setHeight(res.getHeight());
		} catch (FileNotFoundException e) {
			try {
				// https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
				properties.setProperty("adelante", charANombreKeyCode('d'));
				// el KeyEvent de java.awt y no de javafx
				properties.setProperty("detras", charANombreKeyCode('a'));
				properties.setProperty("saltar", charANombreKeyCode(' '));
				properties.setProperty("escalar", charANombreKeyCode('w'));
				properties.setProperty("bajar", charANombreKeyCode('s'));
				properties.setProperty("volumenAmount", "100");
				properties.setProperty("musicaAmount", "100");
				properties.setProperty("resolucion", "res1080x720p");

				if (!RootMenuController.ruta_config_folder.exists()) {
					RootMenuController.ruta_config_folder.mkdirs();
				}

				properties.store(new FileOutputStream(RootMenuController.rutaFull), "");

			} catch (IOException e1) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Error");
				alerta.setHeaderText("No se han podido guardar los controles del teclado.");
				alerta.setContentText(e.getMessage());
				alerta.show();
			}
		} catch (IOException e) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error");
			alerta.setHeaderText("No se han podido cargar los controles del teclado.");
			alerta.setContentText(e.getMessage());
			alerta.show();
		}
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

	public String charANombreKeyCode(char c) {
		return "" + java.awt.event.KeyEvent.getExtendedKeyCodeForChar(c);
	}

	public void setView(BorderPane view) {
		this.view = view;
	}

	public BorderPane getView() {
		return view;
	}

	public void setWindowResolution(int w, int h) {
		Stage stage = (Stage) view.getScene().getWindow();
		stage.setWidth(w);
		stage.setHeight(h);
		stage.centerOnScreen();
	}

	// Cambiar al menu de jugar
	@FXML
	void onJugarClickAction(MouseEvent event) throws IOException {
		jugarMenuController.setAnteriorView(view);
		MonkeyBrosApp.scene.setRoot(jugarMenuController.getView());
		// https://stackoverflow.com/questions/37106379/why-doesnt-my-scene-pop-up-when-changing-scenes-javafx
	}

	// Cambiar al menu de Highscore
	@FXML
	void onHighscoreClickAction(MouseEvent event) {
		System.out.println(menuOpcionesBoton.getScene().getHeight());
	}

	// Cambiar al menu de opciones
	@FXML
	void onOpcionesClickAction(MouseEvent event) {
		opcionesMenuController = new OpcionesMenuController();
		opcionesMenuController.setAnteriorView(view);
		opcionesMenuController.setProperties(properties);
		MonkeyBrosApp.scene.setRoot(opcionesMenuController.getView());
	}

	// Salir del juego
	@FXML
	void onSalirClickAction(MouseEvent event) {
		Stage appVentana = (Stage) menuSalirBoton.getScene().getWindow();
		appVentana.close();
	}
}
