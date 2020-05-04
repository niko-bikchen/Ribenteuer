//developed by Vladyslav Haponenko
package model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//the class controls retrieving data about users

public interface UserRepository extends MongoRepository<User, String> {

    public User findByMail(String mail);

    public Optional<User> findByLogin(String login);
}
