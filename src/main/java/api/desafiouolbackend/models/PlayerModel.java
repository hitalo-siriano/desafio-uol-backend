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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name = "TB_PLAYER")
public class PlayerModel  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPlayer;
    
    @NotNull
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 255, nullable = false,unique = true)
    @NotNull
    private String email;
    @Column(length = 255, nullable = false)
    @NotNull
    private String fone;
    @NotNull
    @Column(length = 255, nullable = false,unique = true)
    private String nickname;
    @NotNull
    @Column(length = 255, nullable = false)
    private String grouphero;
	public UUID getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(UUID idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGrouphero() {
		return grouphero;
	}
	public void setGrouphero(String grouphero) {
		this.grouphero = grouphero;
	}
    
    


    
}
