package com.Maventic.OCR.UserServices.Models;

import com.Maventic.OCR.UserServices.Entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private Boolean isEnabledFlag;
    private Boolean isCredentialsNonExpiredFlag;
    private Boolean isAccountNonLockedFlag;
    private Boolean isAccountNonExpiredFlag;
    private List<GrantedAuthority> authorities;

    //**************** all Constructor ***********************************************************


    public MyUserDetails() {
    }

    public MyUserDetails(String userName, String password, Boolean isEnabledFlag,
                         Boolean isCredentialsNonExpiredFlag, Boolean isAccountNonLockedFlag,
                         Boolean isAccountNonExpiredFlag) {
        this.userName = userName;
        this.password = password;
        this.isEnabledFlag = isEnabledFlag;
        this.isCredentialsNonExpiredFlag = isCredentialsNonExpiredFlag;
        this.isAccountNonLockedFlag = isAccountNonLockedFlag;
        this.isAccountNonExpiredFlag = isAccountNonExpiredFlag;
    }

    public MyUserDetails(User user) {
        this.userName = user.getEmail();
        this.password = user.getPassword();
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority("ROLE_"+user.getUserRole()));
        this.authorities = auth;
        this.isEnabledFlag = true;
        this.isAccountNonLockedFlag=true;
        this.isAccountNonExpiredFlag=true;
        this.isCredentialsNonExpiredFlag =true;
    }

    //**************** all OverRide Method of UserDetails ***********************************************************

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpiredFlag;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLockedFlag;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpiredFlag;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabledFlag;
    }

    //**************** all Getter Setter ***********************************************************

//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Boolean getEnabledFlag() {
//        return isEnabledFlag;
//    }
//
//    public void setEnabledFlag(Boolean enabledFlag) {
//        isEnabledFlag = enabledFlag;
//    }
//
//    public Boolean getCredentialsNonExpiredFlag() {
//        return isCredentialsNonExpiredFlag;
//    }
//
//    public void setCredentialsNonExpiredFlag(Boolean credentialsNonExpiredFlag) {
//        isCredentialsNonExpiredFlag = credentialsNonExpiredFlag;
//    }
//
//    public Boolean getAccountNonLockedFlag() {
//        return isAccountNonLockedFlag;
//    }
//
//    public void setAccountNonLockedFlag(Boolean accountNonLockedFlag) {
//        isAccountNonLockedFlag = accountNonLockedFlag;
//    }
//
//    public Boolean getAccountNonExpiredFlag() {
//        return isAccountNonExpiredFlag;
//    }
//
//    public void setAccountNonExpiredFlag(Boolean accountNonExpiredFlag) {
//        isAccountNonExpiredFlag = accountNonExpiredFlag;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setAuthorities(List<GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }
    //**************** all To string Method ***********************************************************

//    @Override
//    public String toString() {
//        return "MyUserDetails{" +
//                "userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                ", isEnabledFlag=" + isEnabledFlag +
//                ", isCredentialsNonExpiredFlag=" + isCredentialsNonExpiredFlag +
//                ", isAccountNonLockedFlag=" + isAccountNonLockedFlag +
//                ", isAccountNonExpiredFlag=" + isAccountNonExpiredFlag +
//                ", user=" + user +
//                '}';
//    }
}
