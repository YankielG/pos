package pl.edu.wszib.pos.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.repository.UserRepository;

import javax.persistence.Id;
import java.util.List;


@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

//    public List<User> getUsers(){
//       return userRepository.findByIdAndUFNameAndULName();
//    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
