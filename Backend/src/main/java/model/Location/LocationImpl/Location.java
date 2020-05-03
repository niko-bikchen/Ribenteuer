//developed by Vladyslav Haponenko
package model.Location.LocationImpl;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;


//the class is responsible for description of the chosen run by user
@Getter
@Setter
public abstract class Location {

    @Id
    protected String id;
    protected List<Room> rooms;
}
