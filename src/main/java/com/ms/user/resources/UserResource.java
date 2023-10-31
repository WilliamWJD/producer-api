package com.ms.user.resources;

import com.ms.user.domain.User;
import com.ms.user.dto.UserRecordDto;
import com.ms.user.services.UserService;
import com.ms.user.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(final UserServiceImpl userServiceImpl){
        this.userService = userServiceImpl;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDto userDto){
        var userModel = new User();
        BeanUtils.copyProperties(userDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
