package com.example.springweek1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRole {
  private Integer ID;
  private String Name;

  public UserRole() {}

  public static List<UserRole> getAllRoles() {
    List<UserRole> listOfRoles = new ArrayList<UserRole>();
    UserRole role;
    for (Integer i = 0; i < RoleEnum.values().length; i++) {
      role = new UserRole();
      role.ID = i;
      role.Name = RoleEnum.values()[i].name();
      listOfRoles.add(role);
    }
    return listOfRoles;
  }

  public Integer getID() {
    return ID;
  }

  public String getName() {
    return Name;
  }
}
