package com.ote.test;


/**
 * Created by Olivier on 05/06/2016.
 */
public class Application {


    public static void main(String... args) {
        System.out.println(new Foo().power(2, 4));

        User user = new User();
        user.setLogin("toto");
        user.setPassword("toto");
        System.out.println(user.toString());
    }
}
