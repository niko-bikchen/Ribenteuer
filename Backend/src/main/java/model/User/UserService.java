//developed by Vladyslav Haponenko
package model.User;


//all classes which will implement the interface will be responsible for
//interaction with UserRepository class
public interface UserService {

    //TODO
    void createUser();

    void deleteUser(String id);

    User findUserById(String id);

}
