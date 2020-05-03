package model.Trip;

import model.Character.GameCharacter;
import model.FhightChar.FightCharacter;
import model.Location.LocationImpl.LocationType;

public interface TripService {

     Trip makeTrip(GameCharacter character, LocationType locType);

     Trip findByCharId(String charId);

     void endTrip(Trip trip);



}
