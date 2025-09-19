package br.com.rafaelgcaldas.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDto {

    @Schema(example = "Desenvolvedor Java com 5 anos de experiência em aplicações web.")
    private String description;

    @Schema(example = "john_doe")
    private String username;

    @Schema(example = "johndoe@email.com")
    private String email;

    @Schema(example = "John Doe")
    private String name;
    private UUID id;
}
