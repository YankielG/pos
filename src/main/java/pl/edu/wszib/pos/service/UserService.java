package pl.edu.wszib.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

}
