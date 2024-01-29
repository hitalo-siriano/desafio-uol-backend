package api.desafiouolbackend.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.desafiouolbackend.models.PlayerModel;
import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel,UUID> {
    @Query("SELECT t.grouphero FROM PlayerModel")
    List<PlayerModel> findGrouphero();
}
