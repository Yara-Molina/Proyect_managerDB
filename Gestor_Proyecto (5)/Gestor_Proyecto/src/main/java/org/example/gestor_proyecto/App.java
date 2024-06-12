package org.example.gestor_proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.gestor_proyecto.controller.HomeController;
import org.example.gestor_proyecto.controller.LoginController;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.io.IOException;

public class App extends Application {
    public static Stage stageView;
    private static Stage stageRoot;

    @Override
    public void start(Stage stage) throws IOException {
        stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
        Parent root = fxmlLoader.load();
        LoginController controller = fxmlLoader.getController();
        controller.init(stageRoot);


        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void newStage(String fxml, String title) {
        stageView = new Stage();
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
            scene = new Scene(loadFXML(fxml));
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stageView.setTitle(title);
            stageView.setScene(scene);
            stageView.centerOnScreen();
            stageView.initOwner(stageRoot);
            stageView.initModality(Modality.APPLICATION_MODAL);
            stageView.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fmxl"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}