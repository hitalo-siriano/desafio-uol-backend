package api.desafiouolbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PlayerController {


    @PostMapping("/api/v1/desafio/uol/new/player")
    public ResponseEntity<Object> saveNewPlayer(){


       

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
