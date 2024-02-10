package api.desafiouolbackend.services;

import java.sql.SQLException;

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
}
