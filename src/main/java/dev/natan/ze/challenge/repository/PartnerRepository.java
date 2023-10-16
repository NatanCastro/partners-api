package dev.natan.ze.challenge.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.natan.ze.challenge.entity.Partner;

/**
 * PartnerRepository
 */
@Repository
public interface PartnerRepository extends MongoRepository<Partner, ObjectId> { 
}
