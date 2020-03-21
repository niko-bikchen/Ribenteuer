package model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(String mail,String pass) {
        userRepository.save(new User(mail,pass));
    }

    //the method deletes a User
    //
    //after the method is called deleteAllByOwnerId method from CharacterServiceImpl must be called
    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return  userRepository.findByMail(email);
    }
}
