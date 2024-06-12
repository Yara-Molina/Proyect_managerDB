package org.example.gestor_proyecto.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.gestor_proyecto.App;
import org.example.gestor_proyecto.models.Empleado;
import org.example.gestor_proyecto.models.Tarea;
import org.example.gestor_proyecto.models.TipoProyecto;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProyectoVistaController implements Initializable {

    @FXML
    private Button CrearButton;


    @FXML
    private Button EliminarButton;

    @FXML
    private ListView<String> ListViewProyecto;

    @FXML
    private Button ModButton;

    @FXML
    private TableColumn<TipoProyecto, LocalDate> FechaFproyecto;

    @FXML
    private TableColumn<TipoProyecto, LocalDate> FechaIproyecto;

    @FXML
    private TableColumn<TipoProyecto, String> desProyecto;

    @FXML
    private TableColumn<TipoProyecto, String> nomProyecto;

    @FXML
    private TableView<TipoProyecto> ProyectoTableView;

    private ObservableList<TipoProyecto> tipoProyectos;
    private TipoProyecto proyecto;
    private ArrayList<TipoProyecto> tipoProyectoArrayList;
    private ArrayList<Empleado> empleadoArrayList;

    private ArrayList<Tarea> tareaArrayList;

    @FXML
    private Button GuardarButton;

    @FXML
    private Button volverButton;
    @FXML
    private Button verButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (tipoProyectos == null) {
            tipoProyectos = FXCollections.observableArrayList();
        }
        this.ProyectoTableView.setItems(tipoProyectos);
        this.nomProyecto.setCellValueFactory(new PropertyValueFactory<>("nombreProject"));
        this.desProyecto.setCellValueFactory(new PropertyValueFactory<>("descripcionProyect"));
        this.FechaIproyecto.setCellValueFactory(new PropertyValueFactory<>("starDate"));
        this.FechaFproyecto.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }

    @FXML
    void crearButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/gestor_proyecto/CrearProyecto-view.fxml"));
            Parent root = loader.load();

            ProyectoNuevoController proyectoNuevoController = loader.getController();
            proyectoNuevoController.initAttributtes(tipoProyectos);
            proyectoNuevoController.setTipoProyectoArrayList(tipoProyectoArrayList);
            proyectoNuevoController.setEmpleadoArrayList(empleadoArrayList);
            proyectoNuevoController.setTareaArrayList(tareaArrayList);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            TipoProyecto p = proyectoNuevoController.getProyecto();
            if (p != null) {
                this.tipoProyectos.add(p);
                tipoProyectoArrayList.add(p);
                this.ProyectoTableView.refresh();
            }

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void ModButton(ActionEvent event) {
        TipoProyecto p = this.ProyectoTableView.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar un proyecto");
            alert.showAndWait();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/gestor_proyecto/CrearProyecto-view.fxml"));
                Parent root = loader.load();

                ProyectoNuevoController proyectoNuevoController = loader.getController();
                proyectoNuevoController.initAttributtes(tipoProyectos, p);

                proyectoNuevoController.setProyectoVistaController(this);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                TipoProyecto aux = proyectoNuevoController.getProyecto();

                if (aux != null) {
                    int index = tipoProyectos.indexOf(p);
                    if (index != -1) {
                        tipoProyectos.set(index, aux);
                        this.ProyectoTableView.refresh();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se pudo encontrar el proyecto en la lista");
                        alert.showAndWait();
                    }
                }

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void EliminarButton(ActionEvent event) {
        {
            TipoProyecto p = this.ProyectoTableView.getSelectionModel().getSelectedItem();

            if (p == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debes seleccionar un proyecto");
                alert.showAndWait();
            } else {

                this.tipoProyectos.remove(p);
                this.ProyectoTableView.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Se ha borrado el proyecto");
                alert.showAndWait();

            }
        }

    }

    public void setListViewProyecto(ListView<String> listViewProyecto) {
        ListViewProyecto = listViewProyecto;
    }

    @FXML
    void volverButton(ActionEvent event) {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Menu-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            HomeController controller= fxmlLoader.getController();
            controller.setEmpleadoArrayList(empleadoArrayList);
            controller.setTipoProyectoArrayList(tipoProyectoArrayList);
            controller.setTareaArrayList(tareaArrayList);
            controller.initialize();
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ver();
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();

    }

    @FXML
    void verButton(ActionEvent event) {
        ProyectoNuevoController controller = new ProyectoNuevoController();
        ObservableList<TipoProyecto> tipoProyectos1 = controller.getTipoProyectos();
        nomProyecto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProject()));
        desProyecto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcionProyect()));
        FechaIproyecto.setCellValueFactory(cellData -> {
            LocalDate fechaInicio = cellData.getValue().getStarDate();
            return new SimpleObjectProperty<>(fechaInicio);
        });
        FechaFproyecto.setCellValueFactory(cellData -> {
            LocalDate fechaFin = cellData.getValue().getEndDate();
            return new SimpleObjectProperty<>(fechaFin);
        });

        ProyectoTableView.getItems().clear();
        ProyectoTableView.setItems(observableList());

        System.out.println("Lista de empleados obtenida: " + tipoProyectoArrayList);
    }
    public void setTipoProyectoArrayList(ArrayList<TipoProyecto> tipoProyectoArrayList) {
        this.tipoProyectoArrayList = tipoProyectoArrayList;
    }

    public void setEmpleadoArrayList(ArrayList<Empleado> empleadoArrayList) {
        this.empleadoArrayList = empleadoArrayList;
    }

    public void setTareaArrayList(ArrayList<Tarea> tareaArrayList) {
        this.tareaArrayList = tareaArrayList;
    }

    public void initialize() {
        this.empleadoArrayList= empleadoArrayList;
        this.tipoProyectoArrayList = tipoProyectoArrayList;
        this.tareaArrayList= tareaArrayList;
    }
    public void ver() {
        for (TipoProyecto tipoProyecto : tipoProyectoArrayList) {
            System.out.println(tipoProyecto.toString());
        }
    }
    private ObservableList<TipoProyecto> observableList(){
        return FXCollections.observableArrayList(tipoProyectoArrayList);
    }
}
