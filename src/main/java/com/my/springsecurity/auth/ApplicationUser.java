package com.my.springsecurity.auth;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUser implements UserDetails {

	private static final long serialVersionUID = 1L;
    
    private final Set<? extends GrantedAuthority> grantedAuthories;
    private final String password;
    private final String username;
    private final boolean isAcccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    public ApplicationUser(
		Set<? extends GrantedAuthority> grantedAuthories, 
		String username,
        String password,
        boolean isAcccountNonExpired, 
        boolean isAccountNonLocked, 
        boolean isCredentialsNonExpired, 
        boolean isEnabled
    ) {
		this.grantedAuthories = grantedAuthories;
		this.username = username;
        this.password = password;
        this.isAcccountNonExpired = isAcccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthories;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAcccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
    
}
