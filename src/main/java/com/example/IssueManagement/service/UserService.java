package com.example.IssueManagement.service;

import com.example.IssueManagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User save(User user);
    User getById(Long id);
    Page<User> getAllPageable(Pageable pageable);
    User findByUsername(String username);
}
