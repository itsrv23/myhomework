package ru.itsrv.myhomework.course2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableFeignClients
public class MyhomeworkApplication implements CommandLineRunner {

    @Autowired
    Environment env;

    private static final Logger logger = LoggerFactory.getLogger(MyhomeworkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MyhomeworkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("all ok");
        logger.info("samael.custom.prop env: {}",env.getProperty("samael.custom.prop"));

    }
}
