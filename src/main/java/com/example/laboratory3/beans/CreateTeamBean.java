package com.example.laboratory3.beans;

import com.example.laboratory3.entities.City;
import com.example.laboratory3.entities.Team;
import com.example.laboratory3.services.CityService;
import com.example.laboratory3.services.TeamService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Named
@SessionScoped
public class CreateTeamBean implements Serializable {
    @Inject
    private TeamService teamService;

    @Inject
    private CityService cityService;

    private String name;
    private int city;
    private Date founded;

    public void submit() {
        City tempCity = cityService.findById(city);
        teamService.persist(new Team(name, tempCity, founded));
    }
}
