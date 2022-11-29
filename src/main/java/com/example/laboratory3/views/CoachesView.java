package com.example.laboratory3.views;

import com.example.laboratory3.beans.DataViewBean;
import com.example.laboratory3.entities.Coach;
import com.example.laboratory3.services.CoachService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class CoachesView extends DataViewBean<Coach, Integer> {
    @Inject
    CoachService coachService;

    @PostConstruct
    public void init() {
        entities = coachService.findAll();
    }

    public List<Coach> getEntities() {
        entities = coachService.findAll();
        return entities;
    }
}
