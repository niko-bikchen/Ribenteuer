package model.Trip;

import lombok.Getter;
import lombok.Setter;
import model.FhightChar.FightCharacter;
import model.Location.LocationImpl.Location;
import model.Location.LocationImpl.LocationType;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Trip {

    @Id
    private String id;

    private Location location;

    private FightCharacter character;

    private String charId;

    public Trip(FightCharacter character, LocationType locType){

    }


}
