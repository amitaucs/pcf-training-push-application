package com.amisoft.training.controller;


import com.amisoft.training.dto.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class AttendeeController {

    private static final String DEFAULT_ATTENDEE_SERVICE_URI = "http://localhost:8003/attendee";

    @Value(value = "${amisoft.attendee-service.uri}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/addAttendee")
    public ResponseEntity<String> addAttendee(@RequestBody Attendee attendee) throws URISyntaxException {

        String urlWithEndPoint = baseUri+"/addAttendee";
        URI uri = new URI(urlWithEndPoint);

        ResponseEntity<String> response = restTemplate.postForEntity(uri,attendee,String.class);

        return response;

    }


}
