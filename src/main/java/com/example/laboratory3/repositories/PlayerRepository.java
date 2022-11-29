package com.example.laboratory3.repositories;

import com.example.laboratory3.entities.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PlayerRepository extends DataRepository<Player, Integer> {
    private static final String FIRSTNAME = "firstName";
    private static final String POSITION = "position";
    private static final String TEAM_ID = "teamId";

    @PersistenceContext(name = "TPU")
    private EntityManager entityManager;

    public PlayerRepository() {
        super(Player.class);
    }
    public List<Player> findAllBy(String firstName, String position, int teamId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Player> criteriaQuery = criteriaBuilder.createQuery(Player.class);
        Root<Player> from = criteriaQuery.from(Player.class);

        List<Predicate> predicates = new ArrayList<>();
        if (!firstName.equals("")) {
            predicates.add(criteriaBuilder.like(from.get(FIRSTNAME), firstName));
        }
        if (!position.equals("All")) {
            predicates.add(criteriaBuilder.equal(from.get(POSITION), position));
        }
        if (teamId >= 0) {
            predicates.add(criteriaBuilder.equal(from.get(TEAM_ID), teamId));
        }
        if (predicates.isEmpty()) return findAll();

        Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        criteriaQuery.where(finalPredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
