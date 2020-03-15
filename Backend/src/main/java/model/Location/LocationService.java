//developed by Vladyslav Haponenko
package model.Location;


import java.util.List;

//all classes which will implement the interface will be responsible for
//interaction with LocationRepository class
public interface LocationService {

    List<Location> findAllLocations();

    Location findLocationById(String id);

    Location findLocationByUserId(String id);

    //TODO
    void createLocation();

    void deleteLocation(String id);
}
