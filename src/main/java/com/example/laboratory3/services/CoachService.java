package com.example.laboratory3.services;

import com.example.laboratory3.entities.Coach;
import com.example.laboratory3.repositories.CoachRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class CoachService {
    @EJB
    CoachRepository coachRepository;

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    public void persist(Coach coach) {
        coachRepository.persist(coach);
    }

    public void remove(int id) {
        Coach coach = coachRepository.findById(id);
        coachRepository.remove(coach);
    }

    public void update(Coach coach) {
        coachRepository.update(coach);
    }
}
