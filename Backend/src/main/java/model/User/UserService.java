//developed by Vladyslav Haponenko
package model.User;


import java.util.Optional;

//all classes which will implement the interface will be responsible for
//interaction with UserRepository class
public interface UserService {

    //TODO
    void createUser(String mail,String pass);

    void deleteUser(String id);

    Optional<User> findUserById(String id);

    User findUserByEmail(String email);

}
