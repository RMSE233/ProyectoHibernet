package com.example.proyectohibernet.dao;

import com.example.proyectohibernet.database.JPAUtil;
import com.example.proyectohibernet.model.Categoria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDAO {

    public List<Categoria> listar(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
        }
        finally {
            em.close();
        }
    }
}
