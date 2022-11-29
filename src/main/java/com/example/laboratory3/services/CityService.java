package com.example.laboratory3.services;

import com.example.laboratory3.entities.City;
import com.example.laboratory3.repositories.CityRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class CityService {
    @EJB
    CityRepository cityRepository;
    public List<City> findAll() {
        return cityRepository.findAll();
    }
    public void persist(City city) {
        cityRepository.persist(city);
    }
    public City findById(int id) {
        return cityRepository.findById(id);
    }
    public void remove(City city) {
       cityRepository.remove(city);
    }
    public void update(City city) {
        cityRepository.update(city);
    }
}
