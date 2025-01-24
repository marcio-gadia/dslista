package com.superdev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superdev.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository <GameList, Long> {

}
