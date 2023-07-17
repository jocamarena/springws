package com.example.springws.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import stubs.com.example.springws.ws.user_service.User;

@Repository
@Transactional
public class TestRepoEM {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(User user) {
        entityManager.persist(user);
    }
}
