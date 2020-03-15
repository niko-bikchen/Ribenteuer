//developed by Vladyslav Haponenko
package model.Location;

import model.Location.Location;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LocationRepository extends MongoRepository<Location, String> {


}
