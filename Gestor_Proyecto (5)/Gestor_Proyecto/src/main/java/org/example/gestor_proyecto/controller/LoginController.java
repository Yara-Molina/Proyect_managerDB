package org.example.gestor_proyecto.controller;

import org.example.gestor_proyecto.App;
import org.example.gestor_proyecto.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_admin;

    @FXML
    private PasswordField texin_Pass;

    @FXML
    private TextField texin_Uss;
    @FXML
    void btn_registro(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("registro-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            RegistroController registroController= fxmlLoader.getController();
            registroController.initialize();
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
    void btn_admin(MouseEvent event) {
        String usuario = texin_Uss.getText();
        String contraseña = texin_Pass.getText();
        if (!usuario.isEmpty() || !contraseña.isEmpty()) {
            Usuario usuarioEncontrado;
            usuarioEncontrado=Usuario.buscarUsuarioPorCredenciales(usuario, contraseña);
            if (usuarioEncontrado != null) {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Menu-view.fxml"));
                try {
                    Pane root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    HomeController homeController = fxmlLoader.getController();
                    homeController.initialize();
                    stage.setScene(scene);
                    scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Node source = (Node) event.getSource();
                stage = (Stage) source.getScene().getWindow();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Usuario o Contraseña incorrectos");
                alert.showAndWait();
            }
            }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Campos vacios");
            alert.showAndWait();
        }
    }


    @FXML
    public void init(Stage stageRoot) {
    }

    public void initialize() {
    }
}

