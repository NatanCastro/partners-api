package dev.natan.ze.challenge.infrastructure.db;

import dev.natan.ze.challenge.domain.entity.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * PartnerRepository
 */
public interface PartnerRepository extends MongoRepository<Partner, Long> {


}
