package com.footballclub.finder.integration;

import com.footballclub.finder.integration.entity.WikiApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WikiApiClient {

    private static final String WIKIPEDIA_API_URL_WITH_PARAMS =
            "https://en.wikipedia.org/w/api.php?action=query&list=search&format=json&srlimit=10&srsearch=%s";

    @Autowired
    private RestTemplate restTemplate;

    public WikiApiResponse getPagesContainingSearchPhrase(String searchPhrase) {
        return restTemplate.getForObject(String.format(WIKIPEDIA_API_URL_WITH_PARAMS, searchPhrase),
                WikiApiResponse.class);
    }
}
