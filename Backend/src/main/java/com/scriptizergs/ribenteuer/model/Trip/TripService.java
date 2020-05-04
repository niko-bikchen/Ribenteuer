package com.scriptizergs.ribenteuer.model.Trip;

import com.scriptizergs.ribenteuer.model.Character.GameCharacter;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;

public interface TripService {

     Trip makeTrip(GameCharacter character, LocationType locType);

     Trip findByCharId(String charId);

     void endTrip(Trip trip);



}
