package api.desafiouolbackend.services;

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
    NickeNammeService nammeService;


    public void salvePlayer(PlayerNewDto playerNewDto) throws Exception{
     
        if (playerNewDto.grouphero().equalsIgnoreCase("vingadores")) {
           PlayerModel playerModel = new PlayerModel();
           playerModel.setEmail(playerNewDto.email());
           playerModel.setFone(playerNewDto.fone());
           playerModel.setName(playerNewDto.name());
           playerModel.setGrouphero(playerNewDto.grouphero());
           try {
            playerModel.setNickname(nammeService.ValidHeroAvengers());
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

           playerRepository.save(playerModel);


            
        }else if (playerNewDto.grouphero().equalsIgnoreCase("justiça")){

            PlayerModel playerModel = new PlayerModel();
            playerModel.setEmail(playerNewDto.email());
            playerModel.setFone(playerNewDto.fone());
            playerModel.setName(playerNewDto.name());
            playerModel.setGrouphero(playerNewDto.grouphero());
            try {
             playerModel.setNickname(nammeService.ValidHeroJustice());
         } catch (JsonMappingException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (JsonProcessingException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
 
            playerRepository.save(playerModel);
 

        }

    }
}
