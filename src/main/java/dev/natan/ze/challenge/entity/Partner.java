package dev.natan.ze.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("partner")
public class Partner {
  @Id
  private ObjectId id;
  private String tradingName;
  private String document;
  private PartnerCoverageArea coverageArea;
  private PartnerAddress address;
}
