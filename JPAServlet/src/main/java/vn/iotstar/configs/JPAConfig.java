package vn.iotstar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@PersistenceContext
public class JPAConfig {

    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("dataSource");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
