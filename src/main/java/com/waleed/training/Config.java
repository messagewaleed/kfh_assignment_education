package com.waleed.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.waleed.training.wsdl");
        return marshaller;
    }

    @Bean
    public CourseClient countryClient(Jaxb2Marshaller marshaller) {
        CourseClient client = new CourseClient();
        client.setDefaultUri("http://localhost:8082/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}