package com.superdev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superdev.dslist.dtos.GameListDTO;
import com.superdev.dslist.entities.GameList;
import com.superdev.dslist.projection.GameMinProjection;
import com.superdev.dslist.repositories.GameListRepository;
import com.superdev.dslist.repositories.GameRepository;

@Service
public class GameListService {

   @Autowired
   private GameListRepository gameListRepository;

   @Autowired
   private GameRepository gameRepository;

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

   @Transactional
   public void move(Long listId, int origemIndex, int destinoIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(origemIndex);
        list.add(destinoIndex, obj);

        int mim = origemIndex < destinoIndex ? origemIndex : destinoIndex;
        int max = origemIndex < destinoIndex ? destinoIndex : origemIndex;

        for (int i = mim; i <= max; i++) {

            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);

        }
   }
    
}
