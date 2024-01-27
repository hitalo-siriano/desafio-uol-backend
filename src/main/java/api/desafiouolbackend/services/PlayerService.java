package api.desafiouolbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.desafiouolbackend.repositorys.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    
}
