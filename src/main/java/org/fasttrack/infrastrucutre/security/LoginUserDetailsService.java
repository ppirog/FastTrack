package org.fasttrack.infrastrucutre.security;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.loginandregister.LoginAndRegisterFacade;
import org.fasttrack.domain.loginandregister.dto.UserResponseDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@AllArgsConstructor
class LoginUserDetailsService implements UserDetailsService {
    private final LoginAndRegisterFacade loginAndRegisterFacade;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserResponseDto byUsername = loginAndRegisterFacade.findByUsername(username);
        return getUser(byUsername);
    }

    private org.springframework.security.core.userdetails.User getUser(UserResponseDto dto) {
        String role = dto.isAdmin() ? "ADMIN" : "USER";
        return new org.springframework.security.core.userdetails.User(
                dto.username(),
                dto.password(),
                Collections.singletonList(new SimpleGrantedAuthority(role)));
    }
}
