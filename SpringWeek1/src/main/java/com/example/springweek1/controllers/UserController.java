package com.example.springweek1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springweek1.models.User;
import com.example.springweek1.security.JwtTokenUtil;
import com.example.springweek1.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserDetailsServiceImpl userService;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  /**
   * Check if the user with the provided id exist and returns its data.
   * 
   * @return If found, the the first user will be returned otherwise an empty user object with no
   *         data will be returned
   */
  @GetMapping(value = "/{userID}")
  public User getUserById(@PathVariable("userID") String userID) {

    return userService.getUserById(userID);
  }

  /**
   * This method authenticate all priviledged users to log in the web app and returns a valid jwt
   * with default expiration time.
   * 
   * @param requestBody The json serialized object passed in the body of the request containing
   *        user's username and the password to login
   * @return The encoded JWT base64 string
   */
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody User loginUser) {
    
    
    //TODO: Check if user and password is correct
    final User user = userService.loadUserByUserName(loginUser.getUserName());
    if (user != null) {

      final String token = jwtTokenUtil.generateToken(user);
      
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.set("Authorization", token);
      return ResponseEntity.ok().headers(responseHeaders).body("Token Acquired!");
    } else {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Username or password is incorrect");
    }
  }
}
