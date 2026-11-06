package com.example.proyectohibernet.dao;

import com.example.proyectohibernet.database.JPAUtil;
import com.example.proyectohibernet.model.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LibroDAO {

    public void guardar(LibroDAO libroDAO) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // Iniciar la transacción en PostgreSQL
            tx.begin();
            // Decirle a Hibernate que prepare la persistencia del objeto
            em.persist(libroDAO);
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

    public List<LibroDAO> listar() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT l FROM  l ORDER BY l.id", LibroDAO.class).getResultList();
        } finally {
            em.close();
        }
    }
}