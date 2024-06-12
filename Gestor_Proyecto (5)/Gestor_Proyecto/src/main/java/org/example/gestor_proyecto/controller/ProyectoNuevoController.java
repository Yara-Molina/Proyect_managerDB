package org.example.gestor_proyecto.controller;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.gestor_proyecto.models.*;


public class ProyectoNuevoController implements Initializable {

    @FXML
    private Button GuardarButton;

    @FXML
    private Label conectividadLabel;

    @FXML
    private TextField conectividadTextField;

    @FXML
    private TextField descripcionTextField;

    @FXML
    private DatePicker fechaFinalDatePick;

    @FXML
    private DatePicker fechaInicioDatePick;

    @FXML
    private Label frameWorkLabel;

    @FXML
    private TextField frameworkTextField;

    @FXML
    private TextField nameProyectTextField;

    @FXML
    private Label plataformaLabel;

    @FXML
    private TextField plataformaTextField;

    @FXML
    private TextField sistemaOperativoField;

    @FXML
    private Label sistemaOperativoLabel;

    @FXML
    private Label tipoPaginaLabel;

    @FXML
    private TextField tipopaginaTextField;

    @FXML
    private ComboBox<String> tipoProyectoButton;

    private ObservableList<TipoProyecto> tipoProyectos;

    private TipoProyecto Proyecto;

    private ProyectoVistaController proyectoVistaController;

    private ArrayList<Empleado> empleadoArrayList;
    private ArrayList<TipoProyecto>tipoProyectoArrayList;

    private ArrayList<Tarea>tareaArrayList;


    public void setProyectoVistaController(ProyectoVistaController proyectoVistaController) {
        this.proyectoVistaController = proyectoVistaController;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoProyectoButton.getItems().addAll("Escritorio");
        tipoProyectoButton.getItems().addAll("Mobile");
        tipoProyectoButton.getItems().addAll("Pagina web");
        assert GuardarButton != null : "fx:id=\"GuardarButton\" was not injected: check your FXML file 'CrearProyecto-view.fxml'.";
        assert descripcionTextField != null : "fx:id=\"descripcionProyectoTextField\" was not injected: check your FXML file 'CrearProyecto-view.fxml'.";
        assert fechaFinalDatePick != null : "fx:id=\"fechaFinalDatePick\" was not injected: check your FXML file 'CrearProyecto-view.fxml'.";
        assert fechaInicioDatePick != null : "fx:id=\"fechaInicioDatePick\" was not injected: check your FXML file 'CrearProyecto-view.fxml'.";
        assert nameProyectTextField != null : "fx:id=\"nameProyectTextField\" was not injected: check your FXML file 'CrearProyecto-view.fxml'.";
        assert tipoProyectoButton != null : "fx:id=\"tipoProyectoButton\" was not injected: check your FXML file 'CrearProyecto-view.fxml'.";
    }

    public void initAttributtes(ObservableList<TipoProyecto> tipoProyectos) {
        this.tipoProyectos = tipoProyectos;
    }

    public void initAttributtes(ObservableList<TipoProyecto> tipoProyectos, TipoProyecto p) {
        this.tipoProyectos = tipoProyectos;
        this.Proyecto = p;

        this.nameProyectTextField.setText(p.getNombreProject());
        this.descripcionTextField.setText(p.getDescripcionProyect());
        this.fechaInicioDatePick.getValue();
        this.fechaFinalDatePick.getValue();
    }
    @FXML
    void tipoProyectoSeleccionado(ActionEvent event) {
        String tipoSeleccionado = tipoProyectoButton.getValue();
        switch (tipoSeleccionado) {
            case "Escritorio":
                mostrarCamposTipoEscritorio();
                break;
            case "Mobile":
                mostrarCamposTipoMobile();
                break;
            case "Pagina web":
                mostrarCamposTipoPaginaWeb();
                break;
            default:
                break;
        }
    }

    @FXML
    void guardarButton() {
        String tipoSelect = tipoProyectoButton.getValue();
        String nombreProyect = nameProyectTextField.getText();
        LocalDate fechaInicio = fechaInicioDatePick.getValue();
        LocalDate fechaFinal = fechaFinalDatePick.getValue();
        String descripcion = descripcionTextField.getText();
        String conectividad = conectividadTextField.getText();
        String plataforma = plataformaTextField.getText();
        String sistemaOp = sistemaOperativoField.getText();
        String framework = frameworkTextField.getText();
        String tipoPag = tipopaginaTextField.getText();

        Alert alert;

        if (tipoSelect == null || nombreProyect.isEmpty() || fechaInicio == null || fechaFinal == null || descripcion.isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al guardar proyecto");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos.");
            alert.showAndWait();
            return;
        }

        TipoProyecto proyecto = null;

        switch (tipoSelect) {
            case "Escritorio":
                if (sistemaOp.isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error al guardar proyecto");
                    alert.setHeaderText(null);
                    alert.setContentText("Por favor, complete todos los campos.");
                    alert.showAndWait();
                    return;
                }
                proyecto = new ProyectoEscritorio(sistemaOp);
                break;
            case "Mobile":
                if (plataforma.isEmpty() || conectividad.isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error al guardar proyecto");
                    alert.setHeaderText(null);
                    alert.setContentText("Por favor, complete todos los campos.");
                    alert.showAndWait();
                    return;
                }
                proyecto = new ProyectoMobile(conectividad, plataforma);
                break;
            case "Pagina web":
                if (framework.isEmpty() || tipoPag.isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error al guardar proyecto");
                    alert.setHeaderText(null);
                    alert.setContentText("Por favor, complete todos los campos.");
                    alert.showAndWait();
                    return;
                }
                proyecto = new ProyectoPaginaWeb(framework, tipoPag);
                break;
            default:
                break;
        }

        if (proyecto != null) {
            proyecto.setNombreProject(nombreProyect);
            proyecto.setStarDate(fechaInicio);
            proyecto.setEndDate(fechaFinal);
            proyecto.setDescripcionProyect(descripcion);

            this.Proyecto = proyecto;

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guardar proyecto");
            alert.setHeaderText(null);
            alert.setContentText("El proyecto se ha guardado correctamente");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al guardar proyecto");
            alert.setHeaderText(null);
            alert.setContentText("Error al guardar proyecto");
        }

        alert.showAndWait();

        Stage stage = (Stage) GuardarButton.getScene().getWindow();
        stage.close();


    }

    private void mostrarCamposTipoEscritorio () {
            sistemaOperativoField.setVisible(true);
            sistemaOperativoLabel.setVisible(true);
            plataformaLabel.setVisible(false);
            plataformaTextField.setVisible(false);
            conectividadLabel.setVisible(false);
            conectividadTextField.setVisible(false);
            frameWorkLabel.setVisible(false);
            frameworkTextField.setVisible(false);
            tipoPaginaLabel.setVisible(false);
            tipopaginaTextField.setVisible(false);

        }

        private void mostrarCamposTipoMobile () {
            sistemaOperativoField.setVisible(false);
            sistemaOperativoLabel.setVisible(false);
            plataformaLabel.setVisible(true);
            plataformaTextField.setVisible(true);
            conectividadLabel.setVisible(true);
            conectividadTextField.setVisible(true);
            frameWorkLabel.setVisible(false);
            frameworkTextField.setVisible(false);
            tipoPaginaLabel.setVisible(false);
            tipopaginaTextField.setVisible(false);
        }

        private void mostrarCamposTipoPaginaWeb () {
            frameWorkLabel.setVisible(true);
            frameworkTextField.setVisible(true);
            tipoPaginaLabel.setVisible(true);
            tipopaginaTextField.setVisible(true);
            plataformaLabel.setVisible(false);
            plataformaTextField.setVisible(false);
            conectividadLabel.setVisible(false);
            conectividadTextField.setVisible(false);
            sistemaOperativoField.setVisible(false);
            sistemaOperativoLabel.setVisible(false);
    }


    public TipoProyecto getProyecto() {
        return Proyecto;
    }

    public void setEmpleadoArrayList(ArrayList<Empleado> empleadoArrayList) {
        this.empleadoArrayList = empleadoArrayList;
    }

    public void setTipoProyectoArrayList(ArrayList<TipoProyecto> tipoProyectoArrayList) {
        this.tipoProyectoArrayList = tipoProyectoArrayList;
    }

    public void setTareaArrayList(ArrayList<Tarea> tareaArrayList) {
        this.tareaArrayList = tareaArrayList;
    }



    public ObservableList<TipoProyecto> getTipoProyectos() {
        return tipoProyectos;
    }
}


