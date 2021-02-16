package com.coach.askme.controller;

import com.coach.askme.model.User;
import com.coach.askme.repo.UserRepo;
import com.coach.askme.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "유저에 대한 API")
@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @ApiOperation(value = "회원 가입")
    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(@RequestBody User user) {
        user.setUid(userService.getNextSequence("user_sequence"));
        userRepo.save(user);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        Optional<User> userOpt = userRepo.findByNameAndPassword(user.getName(), user.getPassword()); // 이름으로 DB 검색
        if (userOpt != null) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }
    }
}
