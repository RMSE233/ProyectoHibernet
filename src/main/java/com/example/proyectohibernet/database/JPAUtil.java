package com.example.proyectohibernet.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Map;

import java.util.HashMap;

public class JPAUtil {

    private static EntityManagerFactory emf;

    public static synchronized void iniciar() {
        if (emf == null) {
            String password = System.getenv("DB_PASSWORD");

            if (password == null || password.isBlank()) {
                throw new RuntimeException(
                        "DB_PASSWORD environment variable is empty"
                );
            }

            Map<String, Object> properties = new HashMap<>();
            properties.put("jakarta.persistence.jdbc.password", password);

            emf = Persistence.createEntityManagerFactory("bibliotecaPU", properties);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        iniciar();
        return emf;
    }

    public static synchronized void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }

    public static EntityManager getEntityManager() {
    }
}