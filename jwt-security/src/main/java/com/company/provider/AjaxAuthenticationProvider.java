/*
package com.company.provider;

import com.company.service.impl.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

*/
/**
 * 
 * @author vladimir.stankovic
 *
 * Aug 3, 2016
 *//*

@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
    */
/*@Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;*//*

    @Autowired
    private  JwtUserDetailsServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = userService.loadUserByUsername(username);
//        User user = userService.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
       */
/*
        if (!bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }*//*


        if (userDetails.getAuthorities() == null) throw new InsufficientAuthenticationException("User has no roles assigned");
        
        */
/*List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
                .collect(Collectors.toList());
        UserContext userContext = UserContext.create(user.getUsername(), authorities);*//*

//        userDetails.getAuthorities()
//        List<GrantedAuthority> authorities = (List<GrantedAuthority>) userDetails.getAuthorities();
        UserContext userContext = UserContext.create(username, (List<GrantedAuthority>) userDetails.getAuthorities());
        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
*/
