package dev.natan.ze.challenge.domain.entity;

import dev.natan.ze.challenge.domain.dto.CreatePartnerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "partner")
public class Partner {
  @Id
  @MongoId
  private Long id;
  private String tradingName;
  private String ownerName;
  private String document;
  private CoverageArea coverageArea;
  private Address address;

  public Partner(Long id, CreatePartnerDto data) {
    this.tradingName = data.getTradingName();
    this.ownerName = data.getOwnerName();
    this.document = data.getDocument();
    this.coverageArea = data.getCoverageArea();
    this.address = data.getAddress();
    this.id = id;
  }
}
