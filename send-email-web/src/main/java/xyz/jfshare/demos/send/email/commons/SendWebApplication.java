package xyz.jfshare.demos.send.email.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"xyz.jfshare.demos.send.email.mapper"})
public class SendWebApplication {
    public static void main(String[] args){
        SpringApplication.run(SendWebApplication.class,args);
    }
}
