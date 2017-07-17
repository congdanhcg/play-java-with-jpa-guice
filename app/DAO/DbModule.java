package DAO;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by danh.tc on 7/17/2017.
 */
public class DbModule extends AbstractModule {

    private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<EntityManager>();

    @Override
    protected void configure() {
    }

    @Provides @Singleton
    public EntityManagerFactory provideEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("db-manager");
    }

    @Provides
    public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
        if (entityManager == null) {
            ENTITY_MANAGER_CACHE.set(entityManager = entityManagerFactory.createEntityManager());
        }
        return entityManager;
    }

}
