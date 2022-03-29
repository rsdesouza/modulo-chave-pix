package br.com.itau.modulochavepix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.itau.modulochavepix.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Modulo de Cadastro Chave Pix")
                .description(">Desenvolvimento de um gerenciador de cadastro de chaves PIX")
                .version("1.0")
                .contact(contact())
                .build();

    }
    private Contact contact(){
        return new Contact("Rodolfo Silva de Souza",
                "https://githun.com/rsdesouza/",
                "sdesouza.rodolfo@gmail.com");

    }
}
