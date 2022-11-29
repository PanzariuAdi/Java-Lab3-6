package com.example.laboratory3.beans;

import com.example.laboratory3.entities.Assignment;
import com.example.laboratory3.entities.Team;
import com.example.laboratory3.models.Period;
import com.example.laboratory3.services.TeamService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@Getter
@Setter
@RequestScoped
public class ScheduleBean implements Serializable {
    @Inject
    AssignmentManagerBean assignmentManagerBean;
    @Inject
    TeamService teamService;

    private int team1;
    private int team2;
    private int week;
    private int day;

    public void submit() {
        Team t1 = teamService.findById(team1);
        Team t2 = teamService.findById(team2);
        Period period = new Period(week, day);
        assignmentManagerBean.addAssignment(new Assignment(t1, t2, period));
    }
}
