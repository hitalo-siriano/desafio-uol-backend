package api.desafiouolbackend.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.desafiouolbackend.models.PlayerModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel,UUID> {
    
}
