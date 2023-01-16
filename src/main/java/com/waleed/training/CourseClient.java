package com.waleed.training;

import com.waleed.training.wsdl.GetCourseRequest;
import com.waleed.training.wsdl.GetCourseResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CourseClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CourseClient.class);

    public GetCourseResponse getCourses() {

        GetCourseRequest request = new GetCourseRequest();
//        request.setName(course);

//        log.info("Requesting location for " + courses);

        GetCourseResponse response = (GetCourseResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8082/ws/courses", request,
                        new SoapActionCallback(
                                "http://spring.io/kfh/sample/learn/getCourseRequest"));

        return response;
    }

}
