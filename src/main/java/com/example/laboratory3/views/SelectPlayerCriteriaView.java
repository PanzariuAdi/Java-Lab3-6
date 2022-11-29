package com.example.laboratory3.views;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Getter
@Setter
@Named
@RequestScoped
public class SelectPlayerCriteriaView {
    private boolean nameSelected;
    private boolean positionSelected;
    private boolean teamSelected;
    private String name;
    private String position;
    private int teamId;

    @Inject
    private PlayersView playersView;

    public void submit() {
        if (!nameSelected) {
            name = "";
        }
        if (!positionSelected) {
            position = "All";
        }
        if (!teamSelected) {
            teamId = -1;
        }
        playersView.getEntities(name, position, teamId);
    }
}
