package api.desafiouolbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.desafiouolbackend.models.PlayerModel;
import api.desafiouolbackend.repositorys.PlayerRepository;

@Service
public class NicknameService {
    
    @Autowired
    PlayerRepository playerRepository;

    List<PlayerModel> listGrupHeroInvalid = playerRepository.findGrouphero();

    public String nicknameValid(String grupHero){

        if(grupHero.equalsIgnoreCase("Liga da Justiça")){
          
            return null;


        }else if(grupHero.equalsIgnoreCase("Vingadores")){

            return null;

        }
        return null;

        
    }
}
