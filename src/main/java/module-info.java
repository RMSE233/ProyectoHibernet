module com.example.proyectohibernet {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;


    opens com.example.proyectohibernet to javafx.fxml;
    exports com.example.proyectohibernet;
}