package com.Maventic.OCR.UserServices.Services.UserService;

import com.Maventic.OCR.UserServices.Entities.User;
import com.Maventic.OCR.UserServices.Models.MyUserDetails;
import com.Maventic.OCR.UserServices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserAuthenticateServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        ArrayList<SimpleGrantedAuthority> a = new ArrayList<>();
//        a.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return new User("jit","1234",a);
        Optional<User> user = userRepository.findByEmail(username);

        if(user.isPresent()){
            UserDetails u  = user.map(MyUserDetails::new).get();
            return u;
        }
        else
            throw new UsernameNotFoundException("No account with this Email. Please create new account");
    }
}
