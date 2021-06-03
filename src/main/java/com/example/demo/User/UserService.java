package com.example.demo.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserService {

    private EntityManager entityManager;

    public long insert(User user){
        entityManager.persist(user);

        return user.getId();
    }
}
