package api.desafiouolbackend.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PlayerNewDto(@NotNull @Size(max = 255) String  name, @NotNull @Size(max = 255) String email,@NotNull @Size(max = 255) String fone ,@NotNull @Size(max = 255) String grouphero ) {
    
}
