package com.wath.amsui.configuration;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org
import org.springframework.social.facebook.api.impl.FacebookTemplate;

public class FacebookConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        String accessToken = connection.createData().getAccessToken();
        FacebookTemplate facebookTemplate = new FacebookTemplate(accessToken);
        User user= facebookTemplate.fetchObject("me", User.class,"id","first_name","last_name");

        String displayName = user.getFirstName() + " " + user.getLastName();
        String profile = connection.getImageUrl();
        String facebookId = user.getId();

        return facebookId;
    }
}
