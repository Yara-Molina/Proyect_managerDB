package org.example.gestor_proyecto.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import org.example.gestor_proyecto.App;
import org.example.gestor_proyecto.models.Empleado;
import org.example.gestor_proyecto.models.Tarea;
import org.example.gestor_proyecto.models.TipoProyecto;

public class HomeController  {
    @FXML
    private TextField textBuscar1;
    @FXML
    private Button busqueButton1;
    private ObservableList<TipoProyecto> tipoProyectos;
    @FXML
    private ListView<TipoProyecto> verProyectosListView;

    private ObservableList<Empleado> empleados;
    @FXML
    private ListView<Empleado> empleadoListView;

    @FXML
    private Button cerrarButton;
    @FXML
    private Button busqueButton;

    private ArrayList<Empleado> empleadoArrayList= new ArrayList<>();
    private ArrayList<TipoProyecto>tipoProyectoArrayList = new ArrayList<>();

    private ArrayList<Tarea>tareaArrayList= new ArrayList<>();

    @FXML
    void cerrarButton(ActionEvent event) {

    }
        @FXML
        void irEmpleadoVista(ActionEvent event)  {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("vistasEmpleado.fxml"));
            try {
                Pane root = fxmlLoader.load();
                Scene scene= new Scene(root);
                EmpleadoVistasController empleadoVistasController= fxmlLoader.getController();
                empleadoVistasController.setEmpleadoArrayList(empleadoArrayList);
                empleadoVistasController.setTipoProyectoArrayList(tipoProyectoArrayList);
                empleadoVistasController.setTareaArrayList(tareaArrayList);
                empleadoVistasController.initialize();
                stage.setScene(scene);
                scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();stage.close();
        }

        @FXML
        void irProyectovista(ActionEvent event) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("vistasProyecto.fxml"));
            try {
                Pane root = fxmlLoader.load();
                Scene scene= new Scene(root);
                ProyectoVistaController proyectoVistaController= fxmlLoader.getController();
                proyectoVistaController.setEmpleadoArrayList(empleadoArrayList);
                proyectoVistaController.setTipoProyectoArrayList(tipoProyectoArrayList);
                proyectoVistaController.setTareaArrayList(tareaArrayList);
                proyectoVistaController.initialize();
                stage.setScene(scene);
                scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();stage.close();
        }

        @FXML
        void irTareaVista(ActionEvent event) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("vistasTarea.fxml"));
            try {
                Pane root = fxmlLoader.load();
                Scene scene= new Scene(root);
                TareaVistasController controller= fxmlLoader.getController();
                controller.setEmpleadoArrayList(empleadoArrayList);
                controller.setTipoProyectoArrayList(tipoProyectoArrayList);
                controller.setTareaArrayList(tareaArrayList);
                controller.initialize();
                scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();stage.close();
        }

        @FXML
        void verProyectoView(MouseEvent event) {
for(TipoProyecto tipoProyecto: tipoProyectos){
    tipoProyectos.add(tipoProyecto);
}
verProyectosListView.setItems(tipoProyectos);
        }

    public void initialize() {
this.empleadoArrayList= empleadoArrayList;
this.tipoProyectoArrayList = tipoProyectoArrayList;
this.tareaArrayList = tareaArrayList;
    }

    @FXML
    void busqueButton(ActionEvent event) {

    }
    @FXML
    void busqueButton1(ActionEvent event) {

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

    public void init(Stage stageRoot) {
    }
}
