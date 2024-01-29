package api.desafiouolbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.desafiouolbackend.dtos.PlayerNewDto;
import api.desafiouolbackend.models.PlayerModel;
import api.desafiouolbackend.repositorys.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    NicknameService nicknameService;

    public boolean savePlayer(PlayerNewDto playerNewDto){

        try {
            PlayerModel playerModel = new PlayerModel();
            playerModel.setName(playerNewDto.name());
            playerModel.setEmail(playerNewDto.email());
            playerModel.setFone(playerNewDto.fone());
            playerModel.setGrouphero(playerNewDto.grouphero());
            playerModel.setNickname(nicknameService.nicknameValid(playerNewDto.grouphero()));

   

            
            return true;
        } catch (Exception e) {
            return false;
        }


    }
    
}
