package com.superdev.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superdev.dslist.dtos.GameListDTO;
import com.superdev.dslist.services.GameListService;

@RestController
@RequestMapping(value="/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id){
        GameListDTO result = gameListService.findById(id);

        return result;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();

        return result;
    }
}
