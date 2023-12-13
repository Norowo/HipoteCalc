package dad.hipotecalc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class CuotasController implements Initializable {
	
	@FXML
    private TableColumn<?, ?> amortizadoColumn;

    @FXML
    private TableColumn<?, ?> anoColumn;

    @FXML
    private TableColumn<?, ?> cuotaMesColumn;

    @FXML
    private TableView<?> cuotasTable;

    @FXML
    private TableColumn<?, ?> inicialColumn;

    @FXML
    private TableColumn<?, ?> interesesColumn;

    @FXML
    private TableColumn<?, ?> mesColumn;

    @FXML
    private TableColumn<?, ?> numeroColumn;

    @FXML
    private TableColumn<?, ?> pendienteColumn;

    @FXML
    private HBox view;
    
    public CuotasController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CuotasView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public HBox getView() {
		return view;
	}
}
