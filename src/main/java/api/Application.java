package api;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicates;

/**
 * @author codenozzle
 *
 */
@SpringBootApplication
@EnableSwagger2
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(swaggerInfo())
            .useDefaultResponseMessages(false)
            .select()
            .paths(regex("/.*"))
            .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
            .build();
    }

	private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder()
	        .title("SQ Supplier PoC")
	        .description("REST API documentation")
	        .version("1.0")
	        .build();
    }

}
