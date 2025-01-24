package com.superdev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superdev.dslist.dtos.GameListDTO;
import com.superdev.dslist.entities.GameList;
import com.superdev.dslist.repositories.GameListRepository;

@Service
public class GameListService {

   @Autowired
   private GameListRepository gameListRepository;

   @Transactional(readOnly = true)
   public GameListDTO findById (Long id) {
       GameList result = gameListRepository.findById(id).get();
       GameListDTO dto = new GameListDTO(result);
       return dto;
   }

   @Transactional(readOnly = true)
   public List<GameListDTO> findAll() {

       List<GameList> result = gameListRepository.findAll();
       List<GameListDTO> dtos = result.stream().map(x -> new GameListDTO(x)).toList();
       return dtos;
       
   }
    
}
