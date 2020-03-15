//developed by Vladyslav Haponenko
package model;

import org.springframework.data.mongodb.repository.MongoRepository;

//the class controls retrieving data about users

public interface UserRepository extends MongoRepository<User, String>{

    public User findByEmail(String email);
}
