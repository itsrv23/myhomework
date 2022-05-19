package ru.itsrv.myhomework.course2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MyhomeworkApplication implements CommandLineRunner {

    @Autowired
    Environment env;

    public static void main(String[] args) {
        SpringApplication.run(MyhomeworkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("samael.custom.prop env: " + env.getProperty("samael.custom.prop"));
    }
}
