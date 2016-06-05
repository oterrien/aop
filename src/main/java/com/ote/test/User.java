package com.ote.test;

import lombok.Data;
import lombok.Getter;

/**
 * Created by Olivier on 05/06/2016.
 */
@Data
public class User {

    @OnUpdate
    private String login;
    private String password;

    @Loggable
    public void setLogin(String login){
        this.login = login;
    }
}
