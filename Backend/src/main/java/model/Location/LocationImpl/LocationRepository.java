//developed by Vladyslav Haponenko
package model.Location.LocationImpl;

import model.Location.LocationImpl.Location;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LocationRepository extends MongoRepository<Location, String> {


}
