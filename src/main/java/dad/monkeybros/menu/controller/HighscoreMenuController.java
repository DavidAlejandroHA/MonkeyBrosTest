package dad.monkeybros.menu.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.monkeybros.MonkeyBrosApp;
import dad.monkeybros.api.GlobalStat;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class HighscoreMenuController implements Initializable {
	
	// model
	private ListProperty<String> listaScores = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	// view
	@FXML
	private StackPane contenedorScores;

	@FXML
	private Label highscoreLabel;

	@FXML
	private ListView<String> highscoreLista;

	@FXML
	private GridPane scoresGridPane;

	@FXML
	private BorderPane view;

	private BorderPane anteriorView;
	
	// GlobalStats
	
	private GlobalStat globalStat;
	
	public HighscoreMenuController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menus/MenuHighscoreView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		listaScores
		highscoreLista.itemsProperty().bind(listaScores);
		
		//listaScores.add()
		try {
			globalStat = new GlobalStat();
			globalStat.createUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//globalStat.createUser();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	public BorderPane getView() {
		return view;
	}

	public void setAnteriorView(BorderPane anteriorView) {
		this.anteriorView = anteriorView;
	}

	public BorderPane getAnteriorView() {
		return anteriorView;
	}

	@FXML
	void onAtrasClickAction(MouseEvent event) {
		MonkeyBrosApp.scene.setRoot(anteriorView);
	}
}
