package com.springconference.presentation;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/conferences")
public class ConferenceEndpoint {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ConferenceResponse> getConferences() {
        ConferenceResponse conferenceResponse = new ConferenceResponse();
        conferenceResponse.id = 1;
        conferenceResponse.name = "TDC";

        return asList(conferenceResponse);
    }

}
