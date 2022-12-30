package com.nbstech.spring.basic.dataacccess.SpringDataJpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Repository
@Transactional
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public PlayerEntity insertPlayer(PlayerEntity player)
    {
        return entityManager.merge(player);
    }

    public PlayerEntity updatePlayer(PlayerEntity player)
    {
        return entityManager.merge(player);
    }

    public PlayerEntity getPlayerById(int id) {
        return entityManager.find(PlayerEntity.class, id);
    }

    public void deleteById(int id){
        PlayerEntity player = entityManager.find(PlayerEntity.class, id);
        entityManager.remove(player);
    }
}