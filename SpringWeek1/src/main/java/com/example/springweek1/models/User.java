package com.example.springweek1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class User {

  private UUID id;
  private String firstName;
  private String lastName;
  private List<UserRole> roles;
  private String password;
  private String userName;

  public User() {
    this.id = UUID.randomUUID();
    //this.firstName = firstName;
    //this.lastName = lastName;
    //this.password = "";
    this.roles = new ArrayList<UserRole>();
  }

  public UUID getID() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Optional<UserRole> getRole(Integer ID) {
    return UserRole.getAllRoles().stream().filter(role -> role.getID().equals(ID)).findFirst();
  }

  public boolean addExistingRoleToUser(UserRole userRole) {
    try {
      this.roles.add(userRole);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public void setUserName(String uname) {
    // TODO Auto-generated method stub
    this.userName = uname;
  }
  
  public String getUserName() {
    // TODO Auto-generated method stub
    return userName;
  }
}
