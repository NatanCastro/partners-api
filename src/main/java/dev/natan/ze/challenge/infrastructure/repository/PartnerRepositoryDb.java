package dev.natan.ze.challenge.infrastructure.repository;

import dev.natan.ze.challenge.domain.dto.CreatePartnerDto;
import dev.natan.ze.challenge.domain.dto.UpdatePartnerDto;
import dev.natan.ze.challenge.domain.entity.Partner;
import dev.natan.ze.challenge.domain.repository.IPartnerRepository;
import dev.natan.ze.challenge.infrastructure.db.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartnerRepositoryDb implements IPartnerRepository {
  @Autowired
  private PartnerRepository partnerRepository;

  @Override
  public List<Partner> find() {
    return partnerRepository.findAll();
  }

  @Override
  public Partner findById(Long id) {
    return partnerRepository.findById(id).orElseThrow();
  }

  public Partner create(CreatePartnerDto data) {
    var id = partnerRepository.count() + 1;
    Partner partner = new Partner(id, data);
    return partnerRepository.save(partner);
  }

  public Partner update(Long id, UpdatePartnerDto data) {
    Partner partner = partnerRepository.findById(id).orElseThrow();
    if (data.getTradingName() != null && !data.getTradingName().isEmpty())
      partner.setTradingName(data.getTradingName());
    if (data.getOwnerName() != null && !data.getOwnerName().isEmpty())
      partner.setOwnerName(data.getOwnerName());
    if (data.getDocument() != null && !data.getDocument().isEmpty())
      partner.setDocument(data.getDocument());
    if (data.getCoverageArea() != null)
      partner.setCoverageArea(data.getCoverageArea());
    if (data.getAddress() != null)
      partner.setAddress(data.getAddress());
    return partnerRepository.save(partner);
  }

  public void delete(Long id) {
    partnerRepository.deleteById(id);
  }
}
