package cn.geoary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaRunBatApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRunBatApplication.class, args);
    }

}
