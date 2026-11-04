package com.example.proyectohibernet.dao;

import com.example.proyectohibernet.database.JPAUtil;
import com.example.proyectohibernet.model.libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LibroDAO {

    public void guardar(Libro libro) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // Iniciar la transacción en PostgreSQL
            tx.begin();
            // Decirle a Hibernate que prepare la persistencia del objeto
            em.persist(libro);
            // Confirmar los cambios en la base de datos
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    public List<Libro> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return em.createQuery("SELECT l FROM Libro l ORDER BY l.id", Libro.class).getResultList();
        }
        finally {
            em.close();
        }
    }
}