package com.bridgelabz.quantitymeasurement.mapper;

import com.bridgelabz.quantitymeasurement.dto.UserDTO;
import com.bridgelabz.quantitymeasurement.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserResponseMapper implements Mapper<User, UserDTO> {
    private final ModelMapper modelMapper;

    @Override
    public UserDTO mapTo(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public User mapFrom(UserDTO userDto) {
        return modelMapper.map(userDto, User.class);
    }
}