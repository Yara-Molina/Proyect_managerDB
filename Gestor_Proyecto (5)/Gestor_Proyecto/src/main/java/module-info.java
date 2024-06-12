module org.example.gestor_proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;


    opens org.example.gestor_proyecto to javafx.fxml;
    exports org.example.gestor_proyecto;
    exports org.example.gestor_proyecto.controller;
    opens org.example.gestor_proyecto.controller to javafx.fxml;
    exports org.example.gestor_proyecto.models;

}