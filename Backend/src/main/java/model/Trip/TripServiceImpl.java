package model.Trip;

import model.FhightChar.FightCharacter;
import model.Location.LocationImpl.LocationType;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {
    @Override
    public Trip makeTrip(FightCharacter character, LocationType locType) {
        return null;
    }

    @Override
    public Trip findByCharId(String charId) {
        return null;
    }

    @Override
    public void endTrip(Trip trip) {

    }
}
