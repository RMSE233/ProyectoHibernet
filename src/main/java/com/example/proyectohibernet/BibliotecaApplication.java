package com.example.proyectohibernet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BibliotecaApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        URL fxml = BibliotecaApplication.class.getResource("libros.fxml");
        if (fxml == null) {
            throw new IOException("No se encontró libros.fxml. Debe estar en "
                    + "src/main/resources/com/example/proyectohibernet/");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxml);
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        stage.setTitle("Registro de Libros");
        stage.setScene(scene);
        stage.show();
    }
}