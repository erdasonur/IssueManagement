package com.example.IssueManagement.api;

import com.example.IssueManagement.dto.UserDto;
import com.example.IssueManagement.impl.UserServiceImpl;
import com.example.IssueManagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Slf4j
@Api()
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @ApiOperation(value = "Get By Id Operation", response = UserDto.class)
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId){
        log.debug("UserController => Get By Id  Param : " + userId);
        return ResponseEntity.ok(userServiceImpl.getById(userId));
    }

    @ApiOperation(value = "Get All By Pageable Operation" , response = TPage.class)
    @GetMapping("/pagination")
    public ResponseEntity<TPage<UserDto>> getAllPageable(Pageable pageable){
        log.debug("Get All By Pageable Param : " + pageable);
        return ResponseEntity.ok(userServiceImpl.getAllPageable(pageable));
    }

    @ApiOperation(value = "Post Operation", response = UserDto.class)
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userServiceImpl.save(userDto));
    }

    @ApiOperation(value = "Update Operation", response = UserDto.class)
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Long userId){
        return ResponseEntity.ok(userServiceImpl.update(userDto, userId));
    }

    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId){
        return ResponseEntity.ok(userServiceImpl.delete(userId));
    }

    @ApiOperation(value = "Get By User Name Operation", response = UserDto.class)
    @GetMapping("/username/{userName}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable String userName){
        log.debug("UserController => Find By User Name  Param : " + userName);
        return ResponseEntity.ok(userServiceImpl.findByUsername(userName));
    }
}
