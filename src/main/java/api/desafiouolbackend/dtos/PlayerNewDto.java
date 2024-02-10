package api.desafiouolbackend.dtos;

import org.hibernate.validator.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PlayerNewDto(@NotBlank @Size(max = 255) String  name, @NotBlank @Email @Size(max = 255) String email,@NotBlank @Size(max = 255) String fone ,@NotBlank @Size(max = 255) String grouphero ) {
    
}
