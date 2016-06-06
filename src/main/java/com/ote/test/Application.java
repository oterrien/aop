package com.ote.test;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner dummyCLR() {

        return args -> {

            Foo foo = new Foo();
            System.out.println(foo.power(2, 4));

            foo.setBar("toto");
            System.out.println(foo.getBar());
        };
    }
}
