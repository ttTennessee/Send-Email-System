package xyz.jfshare.demos.send.email.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@EnableWebMvc
@ComponentScan(basePackages = {"xyz.jfshare.demos.send.email.commons.controller"})
public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("Jin","http://www.jfshare.xyz","929760196@qq.com");
        return new ApiInfoBuilder()
                .title("111")
                .description("222")
                .contact(contact)
                .version("1.0.0")
                .build();
    }
}
