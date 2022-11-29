package com.example.laboratory3.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
})
public class Team extends AbstractEntity<Integer> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;

    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @OneToOne
    private City city;
    private Date founded;

    public Team(String name, City city_id, Date founded) {
        this.name = name;
        this.city = city_id;
        this.founded = founded;
    }

    @Override
    public String toString() {
        return name;
    }
}