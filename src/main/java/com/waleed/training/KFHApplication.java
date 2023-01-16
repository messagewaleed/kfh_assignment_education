package com.waleed.training;

import com.waleed.training.wsdl.GetCourseResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
//@EnableWebMvc
public class KFHApplication {


    public static void main(String[] args) {


        SpringApplication.run(KFHApplication.class, args);
    }

    @Bean
    Docket configSwagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/**"))
                .apis(RequestHandlerSelectors.basePackage("com.waleed.training"))
                .build()

                .apiInfo(new ApiInfo("KFH Student's API",
                        "An Assessment Rest API",
                        "1.0.0",
                        "Learning is fun, so lets keep it free",
                        new Contact("contact", "www.kfh.com", "contact@kfh.com"),
                        "Standard API License",
                        "www.kfh.com",
                        Collections.emptyList()));
    }

//    @Bean
//    CommandLineRunner lookup(CourseClient courseClient) {
//        return args -> {
//			String course = "java";
//
//			if (args.length > 0) {
//				course = args[0];
//			}
//            GetCourseResponse response = courseClient.getCourses();
////			System.err.println(response.getCourses().for);
//            response.getCourses().forEach(System.out::println);
//        };
//    }


}
