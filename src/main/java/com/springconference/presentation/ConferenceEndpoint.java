package com.springconference.presentation;

import com.springconference.repository.ConferenceEntity;
import com.springconference.repository.ConferenceRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/conferences")
public class ConferenceEndpoint {

    private final ConferenceRepository conferenceRepository;

    public ConferenceEndpoint(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ConferenceResponse> getConferences() {
        List<ConferenceEntity> conferences = conferenceRepository.findAll();

        return conferences.stream()
                .map(this::createConferenceResponse)
                .collect(toList());
    }

    private ConferenceResponse createConferenceResponse(ConferenceEntity conferenceEntity) {
        ConferenceResponse conferenceResponse = new ConferenceResponse();

        conferenceResponse.id = conferenceEntity.id;
        conferenceResponse.name = conferenceEntity.name;
        conferenceResponse.place = conferenceEntity.place;

        return conferenceResponse;
    }

}
