package org.example.gestor_proyecto.controller;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public class TareaVistasController implements Initializable {
    @FXML
    private Button CrearEmpleButton;

    @FXML
    private Button EliminarEmpleButton;

    @FXML
    private Button ModEmpleButton;
    @FXML
    private Button volverButton;

    @FXML
    private TableView<Tarea> TareaTableView;

    @FXML
    private TableColumn<Tarea, String> descripcion;

    @FXML
    private TableColumn<Tarea, String> encargado;

    @FXML
    private TableColumn<Tarea, LocalDate> fechafinal;

    @FXML
    private TableColumn<Tarea, LocalDate> fechainicio;

    @FXML
    private TableColumn<Tarea, String> nomTarea;
    @FXML
    private Button verButton;
    private ObservableList<Tarea> tareas;

    private ArrayList<Empleado> empleadoArrayList;
    private ArrayList<TipoProyecto>tipoProyectoArrayList;
    private ArrayList<Tarea> tareaArrayList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tareas = FXCollections.observableArrayList();

        this.TareaTableView.setItems(tareas);
        this.nomTarea.setCellValueFactory(new PropertyValueFactory("nameTarea"));
        this.descripcion.setCellValueFactory(new PropertyValueFactory("description"));
        this.fechainicio.setCellValueFactory(new PropertyValueFactory("startDate1"));
        this.fechafinal.setCellValueFactory(new PropertyValueFactory("endDate1"));
        this.encargado.setCellValueFactory(new PropertyValueFactory("whoMakes"));
    }

    @FXML
    void crearButton(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/gestor_proyecto/creartarea-view.fxml"));
            Parent root = loader.load();

            CrearTareaController tareaController = loader.getController();
            tareaController.initAttributtes(tareas);
            tareaController.setEmpleadoArrayList(empleadoArrayList);
            tareaController.setTipoProyectoArrayList(tipoProyectoArrayList);
            tareaController.setTareaArrayList(tareaArrayList);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Tarea p = tareaController.getTarea();
            if(p!=null){
                this.tareas.add(p);
                tareaArrayList.add(p);
                this.TareaTableView.refresh();
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
    void EliminarButton(ActionEvent event) {
        {
            Tarea p = this.TareaTableView.getSelectionModel().getSelectedItem();

            if (p == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debes seleccionar un empleado");
                alert.showAndWait();
            } else {

                this.tareas.remove(p);
                this.TareaTableView.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Se ha borrado el empleado");
                alert.showAndWait();

            }
        }

    }

    @FXML
    void ModButton(ActionEvent event) {
        Tarea p = this.TareaTableView.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar empleado");
            alert.showAndWait();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/gestor_proyecto/creartarea-view.fxml"));

                Parent root = loader.load();

                CrearTareaController controllertarea = loader.getController();
                controllertarea.initAttributtes(tareas,p);

                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                Tarea aux = controllertarea.getTarea();
                if (aux != null) {
                    this.TareaTableView.refresh();
                }

            }catch (IOException ex){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void verButton(ActionEvent event) {
        CrearTareaController controller = new CrearTareaController();
        Tarea tareas = controller.getTarea();
        nomTarea.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameTarea()));
        descripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
        fechafinal.setCellValueFactory(cellData -> {
            LocalDate fechaInicio = cellData.getValue().getStartDate1();
            return new SimpleObjectProperty<>(fechaInicio);
        });
        fechainicio.setCellValueFactory(cellData -> {
            LocalDate fechaFin = cellData.getValue().getStartDate1();
            return new SimpleObjectProperty<>(fechaFin);
        });

        TareaTableView.setItems(observableList());

    }

    @FXML
    void volverButton(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Menu-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            stage.setTitle("");
            HomeController homeController= fxmlLoader.getController();
            homeController.setEmpleadoArrayList(empleadoArrayList);
            homeController.setTipoProyectoArrayList(tipoProyectoArrayList);
            homeController.setTareaArrayList(tareaArrayList);
            homeController.initialize();
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
    public void setEmpleadoArrayList(ArrayList<Empleado> empleadoArrayList) {
        this.empleadoArrayList = empleadoArrayList;
    }

    public void setTipoProyectoArrayList(ArrayList<TipoProyecto> tipoProyectoArrayList) {
        this.tipoProyectoArrayList = tipoProyectoArrayList;
    }

    public void setTareaArrayList(ArrayList<Tarea> tareaArrayList) {
        this.tareaArrayList = tareaArrayList;
    }
    private ObservableList<Tarea> observableList(){
        return FXCollections.observableArrayList(tareaArrayList);
    }
    public void initialize() {
        this.empleadoArrayList= empleadoArrayList;
        this.tipoProyectoArrayList = tipoProyectoArrayList;
        this.tareaArrayList = tareaArrayList;
    }


}
