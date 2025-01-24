package com.superdev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superdev.dslist.dtos.GameDTO;
import com.superdev.dslist.dtos.GameMinDTO;
import com.superdev.dslist.entities.Game;
import com.superdev.dslist.repositories.GameRepository;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById (Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {

        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dtos = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dtos;
    }

}
