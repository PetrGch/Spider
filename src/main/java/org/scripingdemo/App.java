package org.scripingdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class App implements CommandLineRunner {

    public static void main( String[] args ) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        //
    }
}
