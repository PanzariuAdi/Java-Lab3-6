package com.example.laboratory3.repositories;

import com.example.laboratory3.entities.Coach;

import javax.ejb.Stateless;

@Stateless
public class CoachRepository extends DataRepository<Coach, Integer> {

    public CoachRepository() {
        super(Coach.class);
    }
}
