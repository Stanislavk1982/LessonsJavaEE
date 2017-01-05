package com.dao;

import com.models.UsersEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDAO {

    @PersistenceContext(name = "persistenceJpaTest", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public List<UsersEntity> getAllUsers() {
        return entityManager.createQuery("from UsersEntity ").getResultList();
    }
}
