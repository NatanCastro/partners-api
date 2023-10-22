package dev.natan.ze.challenge.application.rest;

import dev.natan.ze.challenge.application.usecase.PartnerUsecase;
import dev.natan.ze.challenge.domain.dto.CreatePartnerDto;
import dev.natan.ze.challenge.domain.dto.FindPartnerDto;
import dev.natan.ze.challenge.domain.dto.UpdatePartnerDto;
import dev.natan.ze.challenge.domain.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/partners", produces = "application/json")
public class PartnerController {
  @Autowired
  private PartnerUsecase partnerUsecase;

  @GetMapping()
  public ResponseEntity<List<Partner>> findAll(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng) {
    FindPartnerDto findPartnerDto = new FindPartnerDto(lat, lng);
    List<Partner> partners = partnerUsecase.getPartners(findPartnerDto);
    return new ResponseEntity<>(partners, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Partner> findById(@PathVariable("id") Long id) {
    Partner partner = partnerUsecase.getPartner(id);
    return new ResponseEntity<>(partner, HttpStatus.OK);
  }

  @PatchMapping(value = "/{id}", consumes = "application/json")
  public ResponseEntity<Partner> update(@PathVariable("id") Long id, @RequestBody UpdatePartnerDto data) {
    Partner partner = partnerUsecase.updatePartner(id, data);
    return new ResponseEntity<>(partner, HttpStatus.OK);
  }

  @PostMapping(consumes = "application/json")
  public ResponseEntity<Partner> create(@RequestBody CreatePartnerDto data) {
    Partner partner = partnerUsecase.insertPartner(data);
    return new ResponseEntity<>(partner, HttpStatus.CREATED);
  }

  @PostMapping(value = "populate", consumes = "application/json")
  public ResponseEntity<Void> populate(@RequestBody List<CreatePartnerDto> data) {
    partnerUsecase.populate(data);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
