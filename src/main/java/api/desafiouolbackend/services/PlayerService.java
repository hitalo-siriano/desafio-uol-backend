package api.desafiouolbackend.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import api.desafiouolbackend.dtos.PlayerNewDto;
import api.desafiouolbackend.models.PlayerModel;
import api.desafiouolbackend.repositorys.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	NickNameService nickNameService;

	public PlayerModel salvePlayer(PlayerNewDto playerNewDto) throws Exception {

		if (playerNewDto.grouphero().equalsIgnoreCase("avengers")) {
			String heroNickerNameValid = nickNameService.validHeroAvengers();
			if (heroNickerNameValid == "") {
				return new PlayerModel();
			}
			PlayerModel playerModel = new PlayerModel();
			playerModel.setEmail(playerNewDto.email());
			playerModel.setFone(playerNewDto.fone());
			playerModel.setName(playerNewDto.name());
			playerModel.setGrouphero(playerNewDto.grouphero());

			playerModel.setNickname(heroNickerNameValid);

			return playerRepository.save(playerModel);

		} else if (playerNewDto.grouphero().equalsIgnoreCase("justice league")) {
			String heroNickerNameValid = nickNameService.validHeroJustice();
			if (heroNickerNameValid == "") {
				return new PlayerModel();
			}
			PlayerModel playerModel = new PlayerModel();
			playerModel.setEmail(playerNewDto.email());
			playerModel.setFone(playerNewDto.fone());
			playerModel.setName(playerNewDto.name());
			playerModel.setGrouphero(playerNewDto.grouphero());

			playerModel.setNickname(heroNickerNameValid);

			return playerRepository.save(playerModel);

		} else {
			return null;
		}

	}
	public PlayerModel salvePlayer(PlayerNewDto playerNewDto,UUID id) throws Exception {

		if (playerNewDto.grouphero().equalsIgnoreCase("avengers")) {
			String heroNickerNameValid = nickNameService.validHeroAvengers();
			if (heroNickerNameValid == "") {
				return new PlayerModel();
			}
			PlayerModel playerModel = new PlayerModel();
			playerModel.setIdPlayer(id);
			playerModel.setEmail(playerNewDto.email());
			playerModel.setFone(playerNewDto.fone());
			playerModel.setName(playerNewDto.name());
			playerModel.setGrouphero(playerNewDto.grouphero());

			playerModel.setNickname(heroNickerNameValid);

			return playerRepository.save(playerModel);

		} else if (playerNewDto.grouphero().equalsIgnoreCase("justice league")) {
			String heroNickerNameValid = nickNameService.validHeroJustice();
			if (heroNickerNameValid == "") {
				return new PlayerModel();
			}
			PlayerModel playerModel = new PlayerModel();
			playerModel.setIdPlayer(id);
			playerModel.setEmail(playerNewDto.email());
			playerModel.setFone(playerNewDto.fone());
			playerModel.setName(playerNewDto.name());
			playerModel.setGrouphero(playerNewDto.grouphero());

			playerModel.setNickname(heroNickerNameValid);

			return playerRepository.save(playerModel);

		} else {
			return null;
		}

	}
	
	public List <Object> getUser() {
		
		return  playerRepository.viewPlayer();
	}
	public Optional<PlayerModel> updatePlayers(UUID id){
		
	
		return playerRepository.findById(id);
	}
	
	public boolean deletePlayers(UUID id) {
		
		var optionalUser =playerRepository.findById(id);
		
		if (optionalUser.isEmpty()) {
			return  false;
		}else {
			playerRepository.deleteById(id);
			return true;
		}
		
		
		
	}
	
	
}
