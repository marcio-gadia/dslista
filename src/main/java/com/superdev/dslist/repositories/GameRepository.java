package com.superdev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superdev.dslist.entities.Game;

public interface GameRepository extends JpaRepository <Game, Long> {

}
