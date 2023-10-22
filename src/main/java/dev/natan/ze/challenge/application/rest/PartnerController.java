package dev.natan.ze.challenge.application.rest;

import dev.natan.ze.challenge.application.usecase.PartnerUsecase;
import dev.natan.ze.challenge.domain.dto.CreatePartnerDto;
import dev.natan.ze.challenge.domain.dto.FindPartnerDto;
import dev.natan.ze.challenge.domain.dto.UpdatePartnerDto;
import dev.natan.ze.challenge.domain.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/partners", produces = "application/json")
public class PartnerController {
  @Autowired
  private PartnerUsecase partnerUsecase;

  @GetMapping()
  public List<Partner> findAll(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng) {
    FindPartnerDto findPartnerDto = new FindPartnerDto(lat, lng);
    return partnerUsecase.getPartners(findPartnerDto);
  }

  @GetMapping(value = "/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public Partner findById(@PathVariable("id") Long id) {
    return partnerUsecase.getPartner(id);
  }

  @PatchMapping(value = "/{id}", consumes = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public Partner update(@PathVariable("id") Long id, @RequestBody UpdatePartnerDto partner) {
    return partnerUsecase.updatePartner(id, partner);
  }

  @PostMapping(consumes = "application/json")
  @ResponseStatus(value = HttpStatus.CREATED)
  public Partner create(@RequestBody CreatePartnerDto data) {
    return partnerUsecase.insertPartner(data);
  }

  @PostMapping(value = "populate", consumes = "application/json")
  @ResponseStatus(value = HttpStatus.CREATED)
  public void populate(@RequestBody List<CreatePartnerDto> data) {
    partnerUsecase.populate(data);
  }
}
