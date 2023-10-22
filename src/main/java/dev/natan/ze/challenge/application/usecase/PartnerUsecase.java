package dev.natan.ze.challenge.application.usecase;

import dev.natan.ze.challenge.domain.dto.CreatePartnerDto;
import dev.natan.ze.challenge.domain.dto.FindPartnerDto;
import dev.natan.ze.challenge.domain.dto.UpdatePartnerDto;
import dev.natan.ze.challenge.domain.entity.Partner;
import dev.natan.ze.challenge.domain.repository.IPartnerRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PartnerUsecase
 */
@Service
public class PartnerUsecase {
  @Qualifier("partnerRepositoryDb")
  @Resource(name = "partnerRepositoryDb")
  @Autowired
  private IPartnerRepository partnerRepository;

  public List<Partner> getPartners(FindPartnerDto data) {
    List<Partner> partners = partnerRepository.find();
    return partners.stream().filter(p -> {
      Boolean isPointInside = p.getCoverageArea().isPointInside(data.getLat(), data.getLng());
      System.out.println(isPointInside);
      return isPointInside;
    }).toList();
  }

  public Partner getPartner(Long id) {
    return partnerRepository.findById(id);
  }

  public Partner insertPartner(CreatePartnerDto data) {
    return partnerRepository.create(data);
  }

  public void populate(List<CreatePartnerDto> data) {
    data.forEach(partnerRepository::create);
  }

  public Partner updatePartner(Long id, UpdatePartnerDto data) {
    return partnerRepository.update(id, data);
  }

  public void deletePartner(Long id) {
    partnerRepository.delete(id);
  }
}
