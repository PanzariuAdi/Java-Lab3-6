package com.example.laboratory3.services;

import com.example.laboratory3.entities.Player;
import com.example.laboratory3.repositories.PlayerRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class PlayerService {
    @EJB
    PlayerRepository playerRepository;
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
    public List<Player> findAllBy(String firstName, String position, int teamId) {
        return playerRepository.findAllBy(firstName, position, teamId);
    }

    public void persist(Player player) {
        playerRepository.persist(player);
    }

    public void remove(int id) {
        Player player = playerRepository.findById(id);
        playerRepository.remove(player);
    }

    public void update(Player player) {
        playerRepository.update(player);
    }
}
