package com.scriptizergs.ribenteuer.model.Trip;

import lombok.Getter;
import lombok.Setter;
import com.scriptizergs.ribenteuer.model.Character.GameCharacter;
import com.scriptizergs.ribenteuer.model.FhightChar.FightCharacter;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.BaseLocationFactory;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.Location;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationFactory;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;
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
