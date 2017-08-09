package com.company.security;

import com.company.dos.JwtUser;
import com.company.dos.User;
import com.company.dos.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public final class UserDetailsFactory {

	private UserDetailsFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(
				user.getId(),
				user.getUsername(),
				user.getPassword(),
                user.getEmail(),
				mapToGrantedAuthorities(user.getRoles()),
				user.getLastPasswordResetDate()
		);
	}

	private static List<GrantedAuthority> mapToGrantedAuthoritiesJdk7(List<String> authorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (String authority : authorities) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
			grantedAuthorities.add(grantedAuthority);
		}
		return grantedAuthorities;
	}


	private static List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> userRoles) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		userRoles.stream().forEach(userRole -> grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()/*.authority()*/)));
		//roles.stream().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.authority())));
		/*for (UserRole userRole : userRoles) {
			Role role = userRole.getRole();
			String authority = role.authority();
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
			grantedAuthorities.add(grantedAuthority);
		}*/
		return grantedAuthorities;
	}
}

