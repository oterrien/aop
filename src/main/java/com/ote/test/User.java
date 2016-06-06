package com.ote.test;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Olivier on 05/06/2016.
 */
public class User {

    @Getter
    @Setter
    @OnUpdate
    private String login;

    @Getter
    @Setter
    private String password;
}
