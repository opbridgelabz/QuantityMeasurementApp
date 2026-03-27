package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.LoginDTO;
import com.bridgelabz.quantitymeasurement.dto.RegisterDTO;
import com.bridgelabz.quantitymeasurement.dto.UserDTO;

public interface UserService {

    public UserDTO createUser(RegisterDTO registerDTO);

    public String loginUser(LoginDTO loginDTO);

  //  public UserDto getUserById(Long id);
}
