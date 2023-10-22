package dev.natan.ze.challenge.domain.repository;

import dev.natan.ze.challenge.domain.dto.CreatePartnerDto;
import dev.natan.ze.challenge.domain.dto.UpdatePartnerDto;
import dev.natan.ze.challenge.domain.entity.Partner;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


/**
 * IPartnerRepository
 */
@Qualifier
public interface IPartnerRepository {
  List<Partner> find();

  Partner findById(Long id);

  Partner create(CreatePartnerDto data);

  Partner update(Long id, UpdatePartnerDto data);

  void delete(Long id);
}
