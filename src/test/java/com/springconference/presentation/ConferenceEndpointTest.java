package com.springconference.presentation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConferenceEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getConferencesTest() throws URISyntaxException {
        URI uri = new URI(restTemplate.getRootUri() + "/conferences");

        ParameterizedTypeReference<List<ConferenceResponse>> responseType = new ParameterizedTypeReference<List<ConferenceResponse>>(){};

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

        List<ConferenceResponse> conferences = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, responseType).getBody();

        assertEquals(1, conferences.size());

        ConferenceResponse conference = conferences.get(0);
        assertAll("should return conference information",
                () -> assertEquals(1, conference.id),
                () -> assertEquals("TDC", conference.name));
    }

}