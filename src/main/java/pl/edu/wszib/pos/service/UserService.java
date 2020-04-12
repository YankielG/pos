package pl.edu.wszib.pos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    public List<User> findById(){
        List<User> users = new ArrayList<>();
        users.add((User) userRepository.findAll());
        return users;
    }

    public User get(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

//    public List<User> getUsers(){
//       return userRepository.findById();
//    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
