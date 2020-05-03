package pl.edu.wszib.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.Role;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
//public class MyUserDetailsServiceImpl implements UserDetailsService {
    public class MyUserDetailsServiceImpl {


    @Autowired
    private UserService userService;

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String userName) {
//        User user = userService.findUserByUserName(userName);
//        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//        return buildUserForAuthentication(user, authorities);
//    }
//
//    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
//        Set<GrantedAuthority> roles = new HashSet<>();
//        for (Role role : userRoles) {
//            roles.add(new SimpleGrantedAuthority(role.getRole()));
//        }
//        return new ArrayList<>(roles);
//    }
//
//    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                user.getActive(), true, true, true, authorities);
//    }
}
