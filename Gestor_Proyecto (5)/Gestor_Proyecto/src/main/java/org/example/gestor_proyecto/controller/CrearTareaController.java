package org.example.gestor_proyecto.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.gestor_proyecto.models.Empleado;
import org.example.gestor_proyecto.models.Tarea;
import org.example.gestor_proyecto.models.TipoProyecto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CrearTareaController  {

        @FXML
        private TextArea TextFieldDescripTarea;

        @FXML
        private Button crearTareaButton;

        @FXML
        private DatePicker fechafinalDatePicker;

        @FXML
        private DatePicker fechainicioDatePicker;

        @FXML
        private TextField textFielNameTarea;

        @FXML
        private TextField encargadoTextField;

        private Tarea tarea;
        private ObservableList<Tarea> tareas;

        private ArrayList<Empleado> empleadoArrayList;
        private ArrayList<TipoProyecto>tipoProyectoArrayList;

        private ArrayList<Tarea> tareaArrayList;


        public void initAttributtes(ObservableList<Tarea> tareas) {
                this.tareas = tareas;
        }

        public void initAttributtes(ObservableList<Tarea> tareas, Tarea p) {
                this.tareas = tareas;
                this.tarea = p;

                this.textFielNameTarea.setText(p.getNameTarea());
                this.TextFieldDescripTarea.setText(p.getDescription());
                this.fechainicioDatePicker.setValue(p.getStartDate1());
                this.fechafinalDatePicker.setValue(p.getEndDate1());
                this.encargadoTextField.setText(p.getWhoMakes());
        }

        @FXML
        void crearTareaButton(ActionEvent event) {
                String nombreTarea = this.textFielNameTarea.getText();
                String descripTareaText = this.TextFieldDescripTarea.getText();
                LocalDate fechaInicio = this.fechainicioDatePicker.getValue();
                LocalDate fehcafinal = this.fechafinalDatePicker.getValue();
                String encargado = this.encargadoTextField.getText();

                Tarea p = new Tarea(nombreTarea, fechaInicio,fehcafinal,descripTareaText,encargado);

                if (!tareas.contains(p)) {
                        if (this.tarea != null) {
                                this.tarea.setNameTarea(nombreTarea);
                                this.tarea.setDescription(descripTareaText);
                                this.tarea.setStartDate1(fechaInicio);
                                this.tarea.setEndDate1(fehcafinal);
                                this.tarea.setWhoMakes(encargado);

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText(null);
                                alert.setTitle("Informacion");
                                alert.setContentText("Se ha modificado correctamente");
                                alert.showAndWait();
                        } else {
                                this.tarea= p;
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText(null);
                                alert.setTitle("Informacion");
                                alert.setContentText("Se ha añadido la tarea correctamente");
                                alert.showAndWait();
                        }

                        Stage stage = (Stage) crearTareaButton.getScene().getWindow();
                        stage.close();
                } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("La tarea ya existe");
                        alert.showAndWait();
                }
        }
        public Tarea getTarea() {
                return tarea;
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

        public void initialize() {
                this.empleadoArrayList= empleadoArrayList;
                this.tipoProyectoArrayList = tipoProyectoArrayList;
                this.tareaArrayList= tareaArrayList;
        }
        public void ver(){
                for(Tarea empleado1 : tareaArrayList){
                        System.out.println(empleado1.toString());
                }
        }
}













