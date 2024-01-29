package api.desafiouolbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.desafiouolbackend.dtos.PlayerNewDto;
import jakarta.validation.Valid;

@RestController

public class PlayerController {


    @PostMapping("/api/v1/desafio/uol/new/player")
    public ResponseEntity<Object> saveNewPlayer(@RequestBody @Valid PlayerNewDto playerNewDto ){

        
       

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
