package model.Trip;

import model.FhightChar.FightCharacter;
import model.Location.LocationImpl.LocationType;

public interface TripService {

     Trip makeTrip(FightCharacter character, LocationType locType);

     Trip findByCharId(String charId);

     void endTrip(Trip trip);



}
