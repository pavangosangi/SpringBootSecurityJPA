package org.book.keeper.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.book.keeper.entities.LoginInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

public class CustomUserDetails extends LoginInfo implements UserDetails, Serializable {

	private static final long serialVersionUID = -8481177182492127834L;
	private List<String> userRoles;
	
	public CustomUserDetails(LoginInfo loginInfo, List<String> userRoles) {
		super(loginInfo);
		this.userRoles = userRoles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
