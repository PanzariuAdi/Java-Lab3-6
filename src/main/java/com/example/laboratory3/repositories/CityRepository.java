package com.example.laboratory3.repositories;

import com.example.laboratory3.entities.City;

import javax.ejb.Stateless;
@Stateless
public class CityRepository extends DataRepository<City, Integer> {
    public CityRepository() {
        super(City.class);
    }
}
