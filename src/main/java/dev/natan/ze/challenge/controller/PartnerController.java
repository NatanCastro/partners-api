
package dev.natan.ze.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import dev.natan.ze.challenge.entity.Partner;
import dev.natan.ze.challenge.service.PartnerService;

/**
 * PartnerController
 */
@RestController
@RequestMapping(value = "partners")
public class PartnerController {
  @Autowired
  private PartnerService partnerService;

  @GetMapping(value = {"/", ""})
  public ResponseEntity<List<Partner>> getAllPartners() {
    return new ResponseEntity<List<Partner>>(partnerService.allPartners(), HttpStatus.OK);
  }
}
