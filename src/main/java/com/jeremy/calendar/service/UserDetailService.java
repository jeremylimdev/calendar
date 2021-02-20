package com.jeremy.calendar.service;

import com.jeremy.calendar.model.User;
import com.jeremy.calendar.model.UserDetail;
import com.jeremy.calendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " doesn't exist in database."));
        UserDetail userDetail = new UserDetail(user);

        return userDetail;
    }
}
