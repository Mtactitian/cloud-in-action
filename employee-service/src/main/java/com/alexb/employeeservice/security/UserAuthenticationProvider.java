package com.alexb.employeeservice.security;

import com.alexb.employeeservice.repository.security.UserRepository;
import com.alexb.employeeservice.security.model.Role;
import com.alexb.employeeservice.security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthenticationProvider implements AuthenticationManager {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pw = authentication.getCredentials().toString();

        User user = userRepository.getByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("This user does not exist"));

        if (!passwordEncoder.matches(pw, user.getPassword())) {
            throw new BadCredentialsException("The password in incorrect");
        }

        return new UsernamePasswordAuthenticationToken(user, null, AuthorityUtils.createAuthorityList(
                user.getRoles().stream().map(Role::getRoleName).toArray(String[]::new)
        ));
    }
}
