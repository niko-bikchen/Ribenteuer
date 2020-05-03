package model.Trip;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip, String> {

    public Trip findByCharId(String charId);
}
