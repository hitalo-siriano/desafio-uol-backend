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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import api.desafiouolbackend.dtos.PlayerNewDto;
import api.desafiouolbackend.repositorys.PlayerRepository;
import api.desafiouolbackend.services.NickeNammeService;
import api.desafiouolbackend.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController

public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    NickeNammeService nammeService;
    
    @PostMapping("api/player")
   public ResponseEntity<Object> savePlayer(@RequestBody @Valid PlayerNewDto playerNewDto){
      try {
        playerService.salvePlayer(playerNewDto);
        return ResponseEntity.ok().build();

      } catch (Exception e) {
        return ResponseEntity.badRequest().build();
      }
       

      

     
     

    }
}
