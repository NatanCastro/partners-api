package dev.natan.ze.challenge.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  private String type;
  private List<Double> coordinates;
}
