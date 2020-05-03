package model.Trip;

import model.Character.CharacterRepository;
import model.Character.CharacterService;
import model.Character.GameCharacter;
import model.FhightChar.FightCharacter;
import model.Location.LocationImpl.BaseLocationFactory;
import model.Location.LocationImpl.LocationFactory;
import model.Location.LocationImpl.LocationType;
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
