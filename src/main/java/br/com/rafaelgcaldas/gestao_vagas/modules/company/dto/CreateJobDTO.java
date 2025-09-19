package br.com.rafaelgcaldas.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {

  @Schema(example = "Vaga para Desenvolvedor Java Pleno", requiredMode = Schema.RequiredMode.REQUIRED)
  private String description;

  @Schema(example = "GYMPAss, Plano de saúde...", requiredMode = Schema.RequiredMode.REQUIRED)
  private String benefits;

  @Schema(example = "JUNIOR, PLENO, SENIOR", requiredMode = Schema.RequiredMode.REQUIRED)
  private String level;
}
