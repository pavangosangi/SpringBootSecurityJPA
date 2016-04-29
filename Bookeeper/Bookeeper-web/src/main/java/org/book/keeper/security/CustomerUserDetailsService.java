package org.book.keeper.security;

import java.util.List;

import org.book.keeper.entities.LoginInfo;
import org.book.keeper.repositories.UserRepository;
import org.book.keeper.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customerUserDetailsService")
public class CustomerUserDetailsService implements UserDetailsService{
	private final UserRepository userRepository;
	private final UserRoleRepository userRolesRepository;
	
	@Autowired
	public CustomerUserDetailsService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRolesRepository = userRoleRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginInfo loginInfo = userRepository.findByUserName(username);
		if(null==loginInfo) {
			throw new UsernameNotFoundException("No user present with username: "+username);
		} else {
			List<String> userRoles = userRolesRepository.findRoleByUserName(username);
			return new CustomUserDetails(loginInfo, userRoles);
		}
	}
}
