//developed by Vladyslav Haponenko
package model.User;

import model.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;

//the class controls retrieving data about users

public interface UserRepository extends MongoRepository<User, String>{

    public User findByMail(String mail);
}
