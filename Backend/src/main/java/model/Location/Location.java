//developed by Vladyslav Haponenko
package model.Location;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;


//the class is responsible for description of the chosen run by user
@Getter
@Setter
public class Location {

    @Id
    private String id;
    private List<Room> rooms;
}
