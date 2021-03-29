package com.qubit.app.controller;

import com.qubit.app.exception.AppException;
import com.qubit.app.model.RoleName;
import com.qubit.app.model.entity.MstRoleEntity;
import com.qubit.app.model.entity.MstUserEntity;
import com.qubit.app.payload.*;
import com.qubit.app.repository.MstUserRepository;
import com.qubit.app.repository.MstRoleRepository;
import com.qubit.app.security.JwtTokenProvider;
import com.qubit.common.enums.RegistrationType;
import com.qubit.common.enums.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MstUserRepository customerRepository;

    @Autowired
    private MstRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/tokenRequest")
    public TokenResponse authenticateUser(@Valid @RequestBody TokenRequest tokenRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        tokenRequest.getUsername(),
                        tokenRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        TokenResponse tokenResponse = new TokenResponse(jwt);
        return tokenResponse;
    }

    @PostMapping("/registration/self")
    public ApiResponse registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        if(customerRepository.existsByVcUsername(registrationRequest.getUsername())) {
            new ApiResponse (ResponseCode.AUTHENTICATION_FAIL.getCode(), "Username Already Exists!");
        }

        MstRoleEntity customerRole = roleRepository.findByVcRoleName(RoleName.USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        MstUserEntity userEntity = new MstUserEntity(registrationRequest.getUsername(),
                passwordEncoder.encode(registrationRequest.getPassword()),
                registrationRequest.getEmail(),
                registrationRequest.getPhoneNo(),
                RegistrationType.SELF_REG.getType(), Collections.singleton(customerRole));



        userEntity = customerRepository.save(userEntity);


        return new ApiResponse(ResponseCode.OPERATION_SUCCESSFUL.getCode(), "User registered successfully");
    }
}
