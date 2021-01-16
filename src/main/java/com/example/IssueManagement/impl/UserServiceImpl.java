package com.example.IssueManagement.impl;

import com.example.IssueManagement.dto.UserDto;
import com.example.IssueManagement.entity.User;
import com.example.IssueManagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.IssueManagement.repository.UserRepository;
import com.example.IssueManagement.service.UserService;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.getOne(id);
        if(user == null)
            throw new IllegalArgumentException("User doesn't exist with given id : " + id);
        else
            return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto, Long id) {
        User user = userRepository.getOne(id);
        if (user == null)
            throw new IllegalArgumentException("User doesn't exist with given id : " + id);
        else{
            user.setNameSurname(userDto.getNameSurname());
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            User userData = userRepository.save(user);
            return modelMapper.map(userData,UserDto.class);
        }

    }

    @Override
    public Boolean delete(Long id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
        return true;
    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        UserDto[] userDtos = modelMapper.map(page.getContent(), UserDto[].class);
        TPage<UserDto> tpage = new TPage<>();
        tpage.setStat(page, Arrays.asList(userDtos));
        return tpage;
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new IllegalArgumentException("User doesn't exist with given username : " + username);
        return modelMapper.map(user,UserDto.class);
    }
}
