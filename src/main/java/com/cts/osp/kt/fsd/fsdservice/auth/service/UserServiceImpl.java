package com.cts.osp.kt.fsd.fsdservice.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.osp.kt.fsd.fsdservice.entity.FsdRole;
import com.cts.osp.kt.fsd.fsdservice.entity.FsdUser;
import com.cts.osp.kt.fsd.fsdservice.repository.FSDRoleRepository;
import com.cts.osp.kt.fsd.fsdservice.repository.FSDUserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private FSDUserRepository userRepository;
    @Autowired
    private FSDRoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(FsdUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        
       
        userRepository.save(user);
    }

    @Override
    public FsdUser findByUsername(String username) {
        return userRepository.findByusername(username);
    }
}
