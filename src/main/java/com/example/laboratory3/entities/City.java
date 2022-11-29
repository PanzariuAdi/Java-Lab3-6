package com.example.laboratory3.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
        @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name")
})
public class City extends AbstractEntity<Integer> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;
    private String name;
    public City(String name) {
        this.name = name;
    }
}