package com.my.springsecurity.auth;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.my.springsecurity.security.ApplicationUserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository("fake")
public class FakeApplicationUserDAO implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDAO(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

	@Override
	public Optional<ApplicationUser> selectApplicationUserByUserName(String username) {
        return getApplicationUsers()
            .stream()
            .filter(user -> user.getUsername().equals(username))
            .findFirst();
    }
    
    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                ApplicationUserRole.STUDENT.getGrantedAuthrities(),
                "annasmith", 
                passwordEncoder.encode("password"), 
                true,
                true,
                true,
                true
            ),
            new ApplicationUser(
                ApplicationUserRole.ADMIN.getGrantedAuthrities(),
                "linda", 
                passwordEncoder.encode("password"), 
                true,
                true,
                true,
                true
            ),
            new ApplicationUser(
                ApplicationUserRole.ADMINTRAINEE.getGrantedAuthrities(),
                "tom", 
                passwordEncoder.encode("password"), 
                true,
                true,
                true,
                true
            )
        );

        return applicationUsers;
    }
    
}
