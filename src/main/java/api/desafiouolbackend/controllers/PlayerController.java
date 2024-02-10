package api.desafiouolbackend.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import api.desafiouolbackend.dtos.PlayerNewDto;
import api.desafiouolbackend.models.PlayerModel;
import api.desafiouolbackend.repositorys.PlayerRepository;
import api.desafiouolbackend.services.NickNameService;
import api.desafiouolbackend.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController

public class PlayerController {
    @Autowired
    PlayerService playerService;

   

    
    @PostMapping("api/player")
   public ResponseEntity<Object> savePlayer(@RequestBody @Valid PlayerNewDto playerNewDto){
      try {
       PlayerModel responseModel = new PlayerModel();
       responseModel= playerService.salvePlayer(playerNewDto);
       
       if(responseModel.getNickname() == null) {
    	   return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("No more users available!");
       }
        return ResponseEntity.ok().body(responseModel);

      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error, try again, if it persists, contact support@api.com");
      }
       

      

     
     

    }
}
