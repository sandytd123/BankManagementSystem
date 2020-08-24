package com.cts.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.cts.bms.config.JwtTokenUtil;
import com.cts.bms.modal.ApiResponse;
import com.cts.bms.modal.AuthToken;
import com.cts.bms.modal.CustomerRegistration;
import com.cts.bms.modal.LoginUser;
import com.cts.bms.serviceimpl.CustomerRegistrationServiceImpl;


@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomerRegistrationServiceImpl customerService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final CustomerRegistration user = customerService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return new ApiResponse<>(200, "success",new AuthToken(token,loginUser.getUsername(), user.getPanNo()));
    }

}
