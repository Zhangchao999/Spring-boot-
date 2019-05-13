package cn.geoary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.geoary.mapper")
public class SpringBootJdbc02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbc02Application.class, args);
    }

}
