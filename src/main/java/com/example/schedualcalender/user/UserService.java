package com.example.schedualcalender.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
     UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findUserByUsername(username);
        if(username.isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        String password = new BCryptPasswordEncoder().encode(username);


    }

//    @Transactional
//    public UserDetails loadUserById (Long id){
//        User user = userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User not found with id: " + id));
//        return new CustomUserDetail(user);
//    }
}
