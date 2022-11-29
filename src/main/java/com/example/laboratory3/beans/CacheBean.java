package com.example.laboratory3.beans;

import com.example.laboratory3.entities.Team;
import com.example.laboratory3.repositories.TeamRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class CacheBean implements Serializable {
    @EJB
    protected TeamRepository teamRepository;
    protected List<Team> teams;

    public List<Team> getTeams() {
        if(teams == null) {
            teams = teamRepository.findAll();
        }
        return teams;
    }

    public void onTeamUpdate(@Observes Team entity) {
        teams = null;
    }
}
