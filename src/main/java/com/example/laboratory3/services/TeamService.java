package com.example.laboratory3.services;

import com.example.laboratory3.entities.Team;
import com.example.laboratory3.repositories.TeamRepository;
import lombok.NoArgsConstructor;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@NoArgsConstructor
@ApplicationScoped
public class TeamService {
    @EJB
    private TeamRepository teamRepository;

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public void persist(Team team) {
        teamRepository.persist(team);
    }

    public Team findById(int id) {
        return teamRepository.findById(id);
    }
    public void remove(int id) {
        Team team = teamRepository.findById(id);
        teamRepository.remove(team);
    }

    public void update(Team team) {
        teamRepository.update(team);
    }
}
