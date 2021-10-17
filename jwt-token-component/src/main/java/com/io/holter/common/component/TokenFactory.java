package com.io.holter.common.component;


import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.UUID;

public interface TokenFactory {


    String generate(UserDto userDto,
                    Collection<? extends GrantedAuthority> authorities);

    String generateResetPassword(UserDto userDto, Long code);

    String refresh(String token);

}
