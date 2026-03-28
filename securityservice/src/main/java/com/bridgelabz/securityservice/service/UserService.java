package com.bridgelabz.securityservice.service;

import com.bridgelabz.securityservice.dto.LoginDTO;
import com.bridgelabz.securityservice.dto.RegisterDTO;
import com.bridgelabz.securityservice.dto.UserDTO;

public interface UserService {

    public UserDTO createUser(RegisterDTO registerDTO);

    public String loginUser(LoginDTO loginDTO);

  //  public UserDto getUserById(Long id);
}
