package com.example.laboratory3.entities;

import com.example.laboratory3.models.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Assignment extends AbstractEntity<Integer> {
    int id = 0;
    private Team team1;
    private Team team2;
    private Period period;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return getPeriod().equals(that.getPeriod());
    }

    public Assignment(Team team1, Team team2, Period period) {
        this.team1 = team1;
        this.team2 = team2;
        this.period = period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeam1(), getTeam2(), getPeriod());
    }
}
