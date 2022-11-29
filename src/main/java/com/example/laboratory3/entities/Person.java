package com.example.laboratory3.entities;

import com.example.laboratory3.beans.DataViewBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends AbstractEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    protected String firstName;

    @Column(name = "lastname")
    protected String lastName;

    @Column(name = "team_id")
    protected int teamId;

    @Column(name = "date")
    protected Date date;
    public Person(String firstName, String lastName, int teamId, Date date) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.teamId = teamId;
       this.date = date;
    }

}
