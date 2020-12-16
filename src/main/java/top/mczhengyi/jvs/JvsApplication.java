package top.mczhengyi.jvs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.mczhengyi.jvs.mapper")
public class JvsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JvsApplication.class, args);
    }

}
