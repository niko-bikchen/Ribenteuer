package model.Trip;

import lombok.Getter;
import lombok.Setter;
import model.Character.GameCharacter;
import model.FhightChar.FightCharacter;
import model.Location.LocationImpl.BaseLocationFactory;
import model.Location.LocationImpl.Location;
import model.Location.LocationImpl.LocationFactory;
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

    public Trip(GameCharacter character, LocationType locType){
        this.character = new FightCharacter(character);
        this.charId = character.getId();

        BaseLocationFactory factory = new LocationFactory();

        location = factory.generateLocation(character, locType);

    }


}
