package com.my.springsecurity.auth;

import java.util.Optional;

public interface ApplicationUserDAO {
    
    public Optional<ApplicationUser> selectApplicationUserByUserName(String username);
}
