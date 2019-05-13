package xyz.jfshare.demos.send.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"xyz.jfshare.demos.send.email.mapper"})
@ComponentScan(basePackages = {"xyz.jfshare.demos.send.email.service","xyz.jfshare.demos.send.email.config"})
public class SendWebApplication {
    public static void main(String[] args){
        SpringApplication.run(SendWebApplication.class,args);
    }
}
