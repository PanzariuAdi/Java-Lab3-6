package com.example.laboratory3.models;

import com.example.laboratory3.exceptions.InvalidPeriod;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Period {
    int week;
    int day;

    public Period(int week, int day) {
       setWeek(week);
       setDay(day);
    }

    public void setWeek(int week) {
        if (!(week > 0 && week < 53)) {
            throw new InvalidPeriod("Invalid week number !");
        }
        this.week = week;
    }

    public void setDay(int day) {
        if(!(day > 0 && day < 8)) {
            throw new InvalidPeriod("Invalid day number !");
        }
        this.day = day;
    }

}
