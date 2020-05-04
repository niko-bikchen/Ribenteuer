package com.scriptizergs.ribenteuer.model.Trip;

import com.scriptizergs.ribenteuer.model.Character.CharacterService;
import com.scriptizergs.ribenteuer.model.Character.GameCharacter;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    CharacterService characterService;

    @Override
    public Trip makeTrip(GameCharacter character, LocationType locType) {
        Trip trip = new Trip(character,locType);
        tripRepository.save(trip);
        return trip;
    }

    @Override
    public Trip findByCharId(String charId) {
        return tripRepository.findByCharId(charId);
    }

    @Override
    public void endTrip(Trip trip) {
        characterService.updateChar(trip.getCharacter().getCurrentChar());
        tripRepository.delete(trip);
    }
}
