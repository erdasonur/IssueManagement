package com.example.IssueManagement.service;

import com.example.IssueManagement.dto.UserDto;
import com.example.IssueManagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto save(UserDto user);
    UserDto getById(Long id);
    UserDto update(UserDto userDto, Long id);
    Boolean delete(Long id);
    TPage<UserDto> getAllPageable(Pageable pageable);
    UserDto findByUsername(String username);
}
