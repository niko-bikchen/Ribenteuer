package model.Trip;

import model.Character.CharacterService;
import model.Character.GameCharacter;
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
        return new Trip(character,locType);
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
