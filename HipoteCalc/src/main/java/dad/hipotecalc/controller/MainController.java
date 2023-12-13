package dad.hipotecalc.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import dad.hipotecalc.model.Cuota;
import dad.hipotecalc.model.Hipoteca;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {
	
	// controllers
	
	private HipotecaController hipotecaController = new HipotecaController();
	private CuotasController cuotasController = new CuotasController();
	
	// model
	
	private Hipoteca hipoteca = new Hipoteca();
	
	// view
	
	@FXML
	private Tab cuotasTab;

	@FXML
	private Tab hipotecaTab;

	@FXML
	private Button calcularButton;

	@FXML
	private CheckBox cuotasCheckbox;

	@FXML
	private TextField cuotasText;

	@FXML
	private Button exportarButton;

	@FXML
	private Button limpiarButton;

	@FXML
	private BorderPane view;

	public MainController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@FXML
	void onCalcularAction(ActionEvent event) {
		hipoteca.setCliente("Chuck Norris");	// nombre del cliente
		hipoteca.setFecha(LocalDate.now());		// fecha del cálculo
		hipoteca.setCapital(20000);				// importe del préstamo
		hipoteca.setIntereses(3.5);				// porcentaje de interés aplicado
		hipoteca.setPlazo(5);					// duración del préstamo en años  
		
		// TODAS LAS CUOTAS (5 AÑOS = 5 * 12 = 60 CUOTAS)
		hipoteca.calcularCuotas();
		System.out.println(
			"Número" + "\t" + "Año" + "\t" + "Mes" + "\t" + "Capital inicial" + "\t" + 
			"Cuota mensual" + "\t" + "Capital amortizado" + "\t" + 
			"Intereses" + "\t" + "Capital pendiente");
		for (Cuota cuota : hipoteca.getCuotas()) {
			System.out.println(cuota);
		}

		
	}

	@FXML
	void onCuotasAction(ActionEvent event) {

	}

	@FXML
	void onExportarAction(ActionEvent event) {

	}

	@FXML
	void onLimpiarAction(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		hipotecaTab.setContent(hipotecaController.getView());
		cuotasTab.setContent(cuotasController.getView());

	}

	public BorderPane getView() {
		return view;
	}

}
