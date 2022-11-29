package com.example.laboratory3.entities;

import com.example.laboratory3.beans.DataViewBean;
import com.example.laboratory3.enums.Position;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "players")
@NamedQueries({
        @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
        @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id")
})
public class Player extends Person implements Serializable {

    @Column(name = "position")
    protected String position;
    public Player(String firstName,
                  String lastName,
                  int teamId,
                  Date date,
                  String position) {
        super(firstName, lastName, teamId, date);
        this.position = position;
    }
}
