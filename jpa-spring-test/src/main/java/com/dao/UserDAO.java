package com.dao;

import com.models.UsersEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by BGClassTeacher on 29.12.2016.
 */
@Transactional
@Repository
public class UserDAO {

    @PersistenceContext(name = "persistenceJpaTest")
    private EntityManager entityManager;


    public List<UsersEntity> getAllUsers(){
        return entityManager.createQuery("select u from UsersEntity u").
                getResultList();

    }


}
