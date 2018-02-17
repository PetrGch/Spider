package org.scripingdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main( String[] args ) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(UUID.randomUUID().toString() );
    }
}
