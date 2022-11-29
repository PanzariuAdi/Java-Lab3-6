package com.example.laboratory3.repositories;

import com.example.laboratory3.entities.Team;

import javax.ejb.Stateless;

@Stateless
public class TeamRepository extends DataRepository<Team, Integer> {
    public TeamRepository() {
        super(Team.class);
    }
}
