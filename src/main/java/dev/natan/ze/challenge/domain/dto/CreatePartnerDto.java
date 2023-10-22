package dev.natan.ze.challenge.domain.dto;

import dev.natan.ze.challenge.domain.entity.Address;
import dev.natan.ze.challenge.domain.entity.CoverageArea;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 * CreatePartnerDto
 */
@Data
@AllArgsConstructor
public class CreatePartnerDto {
  @NotBlank
  private String tradingName;
  @NotBlank
  private String ownerName;
  @NotBlank
  @CNPJ
  private String document;
  @NotNull
  private CoverageArea coverageArea;
  @NotNull
  private Address address;
}
