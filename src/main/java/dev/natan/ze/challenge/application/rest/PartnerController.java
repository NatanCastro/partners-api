package dev.natan.ze.challenge.application.rest;

import dev.natan.ze.challenge.application.usecase.PartnerUsecase;
import dev.natan.ze.challenge.domain.dto.CreatePartnerDto;
import dev.natan.ze.challenge.domain.dto.FindPartnerDto;
import dev.natan.ze.challenge.domain.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping(value = "/{id}", produces = "application/json")
  @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
  public Partner findById(@PathVariable("id") Long id) {
    return partnerUsecase.getPartner(id);
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  @ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
  public Partner create(@RequestBody CreatePartnerDto data) {
    return partnerUsecase.insertPartner(data);
  }

  @PostMapping(value = "populate", consumes = "application/json")
  @ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
  public void populate(@RequestBody List<CreatePartnerDto> data) {
    partnerUsecase.populate(data);
  }
}
