package com.coach.askme.controller;

import com.coach.askme.config.JwtTokenUtil;
import com.coach.askme.model.JwtRequest;
import com.coach.askme.model.JwtResponse;
import com.coach.askme.model.Member;
import com.coach.askme.repo.MemberRepo;
import com.coach.askme.service.JwtUserDetailsService;
import com.coach.askme.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Optional;

@Api(value = "유저에 대한 API")
@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    MemberRepo memberRepo;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @ApiOperation(value = "회원 가입")
    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(@RequestBody Member user) {
        user.setMid(userService.getNextSequence("member_sequence"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        memberRepo.save(user);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getName(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getName());
//        System.out.println("UserDetails : " + userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @ApiOperation(value = "사용자 정보 가져오기")
    @GetMapping("")
    public HashMap<String,String> getUser(HttpServletRequest request) throws Exception {
//        System.out.println(request);
        final String requestTokenHeader = request.getHeader("Authorization");
        HashMap<String, String> map = new HashMap<>();
        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                Optional<Member> memOpt = memberRepo.findByName(username);
                map.put("name",memOpt.get().getName());
                map.put("mid",memOpt.get().getMid()+"");
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }
        } else {
//            logger.warn("JWT Token does not begin with Bearer String");
        }

        return map;
    }
}
