package api.desafiouolbackend.controllers;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.JDBCException;

import org.hibernate.internal.util.JdbcExceptionHelper;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import api.desafiouolbackend.dtos.PlayerNewDto;
import api.desafiouolbackend.models.PlayerModel;
import api.desafiouolbackend.repositorys.PlayerRepository;

import api.desafiouolbackend.services.PlayerService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController

public class PlayerController {
	@Autowired
	PlayerService playerService;

	@PostMapping("api/player")
	public ResponseEntity<Object> savePlayer(@RequestBody @Valid PlayerNewDto playerNewDto) {
		try {
			PlayerModel responseModel = new PlayerModel();
			
			responseModel = playerService.salvePlayer(playerNewDto);
			
			
			
			

			if (responseModel.getNickname() == null) {
				return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("No more users available!");
			}
			
			return ResponseEntity.ok().body(responseModel);

		} catch (DataIntegrityViolationException e) {
            e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("error, try again, if it persists, contact support@api.com");
		}
	}
	@GetMapping("/api/view/player")
	public ResponseEntity<List<PlayerModel>> getRegisteredUsersReport(){
		try {
		
		return ResponseEntity.status(HttpStatus.OK).body(playerService.getUser());
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
		
		
	@PutMapping("/api/update/player/{id}")
	public ResponseEntity<Object> updatePlayer(@PathVariable(value = "id") UUID id,@RequestBody @Valid PlayerNewDto playerNewDto) throws Exception {

		var optionalUser = playerService.updatePlayers(id);
		if (optionalUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		

        
        


			return ResponseEntity.status(HttpStatus.OK).body(playerService.salvePlayer(playerNewDto,optionalUser.get().getIdPlayer()));
		}
	@DeleteMapping("/api/delete/player/{id}")
	public ResponseEntity<Object> deletePlayer(@PathVariable(value = "id") UUID id){

		
         if(playerService.deletePlayers(id)) {
        	 return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
         }else {
        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
         }
         
		
    
        
        


			
		}
}
