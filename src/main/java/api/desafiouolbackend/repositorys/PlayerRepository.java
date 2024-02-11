package api.desafiouolbackend.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import api.desafiouolbackend.models.PlayerModel;
import java.util.List;



public interface PlayerRepository extends JpaRepository<PlayerModel,UUID> {

    @Query("SELECT t.nickname  FROM PlayerModel t")
    List<String> grouphero();
    
    @Query("SELECT t.name,t.email,t.fone,t.nickname,t.grouphero FROM PlayerModel t")
    List<Object> viewPlayer();
    
}
