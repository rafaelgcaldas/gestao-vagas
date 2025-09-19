package br.com.rafaelgcaldas.gestao_vagas.modules.candidate.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "John Doe", requiredMode = Schema.RequiredMode.REQUIRED, description = "O nome completo do candidato")
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    @Schema(example = "john_doe", requiredMode = Schema.RequiredMode.REQUIRED, description = "Username do candidato")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    @Schema(example = "johndoe@email.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "E-mail do candidato")
    private String email;

    @Length(min = 3, max = 120, message = "A senha deve conter entre 3 e 12 caracteres")
    @Schema(example = "123456", minLength = 10, maxLength = 120, requiredMode = Schema.RequiredMode.REQUIRED, description = "Senha do candidato")
    private String password;

    @Schema(example = "Desenvolvedor Java", requiredMode = Schema.RequiredMode.REQUIRED, description = "Breve descrição do candidato")
    private String description;

    @Schema(example = "Link do currículo do candidato")
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
