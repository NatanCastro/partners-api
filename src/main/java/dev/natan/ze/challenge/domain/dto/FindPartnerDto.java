package dev.natan.ze.challenge.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindPartnerDto {
  Double lat;
  Double lng;
}
