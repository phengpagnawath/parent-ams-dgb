package com.wath.amsui.configuration;

import com.wath.amsui.retrofit.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;

public class FacebookSignInAdapter implements SignInAdapter {

    @Override
    public String signIn(String s, Connection<?> connection, NativeWebRequest nativeWebRequest) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("FACEBOOK_USER"));
        User user = new User();
        user.setId(s);
        user.setDisplayName(connection.getDisplayName());
        user.setProfile(connection.getProfileUrl());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user, null, authorities
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("AUTH = " + authentication.getPrincipal().toString());
        System.out.println("TEST = " + authentication.getAuthorities());
        return null;
    }
}
