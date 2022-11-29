package com.example.laboratory3.views;

import com.example.laboratory3.beans.DataViewBean;
import com.example.laboratory3.entities.Team;
import com.example.laboratory3.services.TeamService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("teamsView")
@ApplicationScoped
public class TeamsView extends DataViewBean<Team, Integer> {
    @Inject
    private TeamService teamService;

    @PostConstruct
    public void init() {
        entities = teamService.findAll();
    }

    public List<Team> getEntities() {
        entities = teamService.findAll();
        return entities;
    }
}