package pl.edu.wszib.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.Role;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.repository.RoleRepository;
import pl.edu.wszib.pos.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private List<User> users = new ArrayList<User>();
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
//
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<User> getUsers() {
        return users;
    }


    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

//    @Bean
//    public CommandLineRunner loadData(UserRepository user) {
//        return (args ->  {
//            user.save(new User("1","true","admin@jakis.mail","admin","admin","$2a$10$E5IdyCTDQkaZNRYeA205xOrU7dyp77mh3pDNRhhBOuaW1gBDo00mi","admin"));
//            user.save(new User("2","true","manager@jakis.mail","manager","manager","$2a$10$kfSwgdgXhL5NNpM/2UivRO9cq37mTbcQrs4igAhvwoIoKumLg0Lp2","manager"));
//            user.save(new User("3","true","user@jakis.mail","user","user","$2a$10$JLrNeTTsJBmKefynnjrypu6mCYfYVWupFheoScyGSZmsauP/5o7Ci","user1"));
//        });
//    }

}
