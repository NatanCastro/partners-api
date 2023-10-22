package dev.natan.ze.challenge.domain.dto;

import dev.natan.ze.challenge.domain.entity.Address;
import dev.natan.ze.challenge.domain.entity.CoverageArea;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 * CreatePartnerDto
 */
@Data
@AllArgsConstructor
public class UpdatePartnerDto {
  private String tradingName;
  private String ownerName;
  @CNPJ
  private String document;
  private CoverageArea coverageArea;
  private Address address;
}
