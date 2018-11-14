package com.example.springweek1.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.springweek1.models.User;
import com.example.springweek1.models.UserRole;

public class UserDetailsServiceImpl implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }

  public User loadUserByUserName(String username) {

    User u = new User();
    u.setFirstName("John");
    u.setLastName("Doe");
    u.setUserName(username);
    u.addExistingRoleToUser(u.getRole(1).get());
    return u;
  }
  
  public User getUserById(String id) {
    User u = new User();
    u.setFirstName("John");
    u.setLastName("Doe");
    u.setUserName("test");
    return u;
  }
}
