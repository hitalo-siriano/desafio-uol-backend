package api.desafiouolbackend.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.core.serializer.Serializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TB_PLAYER")
public class PlayerModel  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPlayer;
    private String name;
    @Column(unique = true)
    private String email;
    private String fone;
    @Column(unique = true)
    private String nickname;
    private String grouphero;


    
}
