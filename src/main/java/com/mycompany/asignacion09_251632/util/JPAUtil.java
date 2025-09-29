package com.mycompany.asignacion09_251632.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("EmpresaPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
