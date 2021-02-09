package com.coach.askme.controller;

import com.coach.askme.model.User;
import com.coach.askme.repo.UserRepo;
import com.coach.askme.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "유저에 대한 API")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @ApiOperation(value = "회원 가입")
    @PostMapping("/signup")
    public ResponseEntity<Boolean> insertQuestion(@RequestBody User user) {
        user.setUid(userService.getNextSequence("user_sequence"));
        userRepo.save(user);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
