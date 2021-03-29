package com.qubit.app.security;

import com.qubit.app.exception.ResourceNotFoundException;
import com.qubit.app.model.entity.MstUserEntity;
import com.qubit.app.repository.MstUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MstUserRepository mstUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        MstUserEntity user = mstUserRepository.findByVcUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserByEmail(String email) {
        MstUserEntity user = mstUserRepository.findByVcEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("User", "email", email)
        );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        MstUserEntity user = mstUserRepository.findByNuUserId(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }
}