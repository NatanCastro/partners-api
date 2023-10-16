package dev.natan.ze.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import dev.natan.ze.challenge.repository.PartnerRepository;
import dev.natan.ze.challenge.entity.Partner;

/**
 * PartnerService
 */
@Service
public class PartnerService {
  @Autowired  
  private PartnerRepository partnerRepository;

  @Transactional(readOnly = true)
  public List<Partner> allPartners() {
    return partnerRepository.findAll();
  }
}
