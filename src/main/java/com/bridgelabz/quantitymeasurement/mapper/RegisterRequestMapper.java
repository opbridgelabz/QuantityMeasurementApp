package com.bridgelabz.quantitymeasurement.mapper;

import com.bridgelabz.quantitymeasurement.dto.RegisterDTO;
import com.bridgelabz.quantitymeasurement.mapper.Mapper;
import com.bridgelabz.quantitymeasurement.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterRequestMapper implements Mapper<RegisterDTO, User> {
    private final ModelMapper modelMapper;
    @Override
    public User mapTo(RegisterDTO signupDto) {
        return modelMapper.map(signupDto, User.class);
    }

    @Override
    public RegisterDTO mapFrom(User user) {
        return modelMapper.map(user, RegisterDTO.class);
    }
}