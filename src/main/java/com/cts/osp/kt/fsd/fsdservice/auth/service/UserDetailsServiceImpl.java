package com.cts.osp.kt.fsd.fsdservice.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.osp.kt.fsd.fsdservice.entity.FsdRole;
import com.cts.osp.kt.fsd.fsdservice.entity.FsdUser;
import com.cts.osp.kt.fsd.fsdservice.repository.FSDUserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private FSDUserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        FsdUser user = userRepository.findByusername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
       // for (FsdRole role : user.getFsdRoles()){
            //grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));//TODO
       // 	grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        //	
      //  }
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
