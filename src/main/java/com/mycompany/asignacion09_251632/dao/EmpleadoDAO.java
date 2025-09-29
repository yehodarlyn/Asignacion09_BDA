package com.mycompany.asignacion09_251632.dao;

import com.mycompany.asignacion09_251632.models.Empleado;
import com.mycompany.asignacion09_251632.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class EmpleadoDAO {

    public void insertar(Empleado e) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(e);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }

    public void actualizar(Empleado e) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(e);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Empleado e = em.find(Empleado.class, id);
            if (e != null) {
                em.remove(e);
            }
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }

    public Empleado buscar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public List<Empleado> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Empleado e", Empleado.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void aumentarSalario(Long id, Double porcentaje) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Empleado e = em.find(Empleado.class, id);
            if (e != null) {
                double nuevo = e.getSalario() * (1 + porcentaje / 100);
                e.setSalario(nuevo);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }
}
