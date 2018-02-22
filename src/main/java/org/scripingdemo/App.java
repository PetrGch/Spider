package org.scripingdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args ) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Start");
    }
}
