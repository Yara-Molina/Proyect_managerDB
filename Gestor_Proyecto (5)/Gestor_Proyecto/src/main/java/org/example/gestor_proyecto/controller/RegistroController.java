package org.example.gestor_proyecto.controller;

import org.example.gestor_proyecto.App;
import org.example.gestor_proyecto.models.DatabaseConnection;
import org.example.gestor_proyecto.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegistroController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button btn_admin;
    @FXML
    private Button btn_back;
    @FXML
    private ComboBox<String> combores;
    @FXML
    private PasswordField texin_newPass;
    @FXML
    private TextField texin_newUss;
    @FXML
    private PasswordField texin_pass2;

    @FXML
    void btn_admin(MouseEvent event) {
        String usuario = texin_newUss.getText();
        String contraseña = texin_newPass.getText();
        String repetir = texin_pass2.getText();

        if (!usuario.isEmpty() && !contraseña.isEmpty() && !repetir.isEmpty()) {
            if (Objects.equals(contraseña, repetir)) {
                if (contraseña.length() == 6) {
                    try {
                        // Obtener conexión a la base de datos
                        Connection connection = DatabaseConnection.getConnection();
                        if (connection != null) {
                            // Crear declaración SQL
                            String sql = "INSERT INTO project_user (user_name, user_password) VALUES (?, ?)";
                            PreparedStatement statement = connection.prepareStatement(sql);
                            statement.setString(1, usuario);
                            statement.setString(2, contraseña);

                            // Ejecutar declaración SQL
                            statement.executeUpdate();

                            // Cerrar declaración y conexión
                            statement.close();
                            connection.close();

                            // Limpiar campos de texto
                            texin_newUss.clear();
                            texin_newPass.clear();
                            texin_pass2.clear();
                        } else {
                            showAlert("Error", "No se pudo establecer conexión con la base de datos.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        showAlert("Error", "Error al conectar a la base de datos: " + e.getMessage());
                    }
                } else {
                    showAlert("Error", "La contraseña tiene que ser de 6 dígitos");
                }
            } else {
                showAlert("Error", "Las contraseñas no coinciden");
            }
        } else {
            showAlert("Error", "Campos vacíos");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void btn_back(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            LoginController controller= fxmlLoader.getController();
            controller.initialize();
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
    void initialize() {
    }

    public void closeWindows() {
    }
}