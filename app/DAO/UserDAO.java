package DAO;


import com.google.inject.Inject;
import models.UserAccount;

import javax.persistence.EntityManager;

/**
 * Created by danh.tc on 7/17/2017.
 */
public class UserDAO {

    protected EntityManager entityManager;

    @Inject
    public UserDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void save(UserAccount userAccount){
        entityManager.getTransaction().begin();
        entityManager.persist(userAccount);
        entityManager.getTransaction().commit();
    }

    public UserAccount get(Long id){
        return entityManager.find(UserAccount.class, id);
    }
}
