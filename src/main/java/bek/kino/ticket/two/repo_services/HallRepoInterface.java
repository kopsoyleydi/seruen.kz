package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.model.Hall;

import java.util.List;

public interface HallRepoInterface {

    List<Hall> getAllHalls();
    Hall addHall(Hall hall);

    Hall getHallById(Long id);
}
