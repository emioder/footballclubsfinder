package com.footballclub.finder.service;

import java.util.List;
import java.util.stream.Collectors;

import com.footballclub.finder.integration.WikiApiClient;
import com.footballclub.finder.integration.entity.WikiApiResponse;
import com.footballclub.finder.integration.entity.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagesFinder {

    private static final String WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";

    @Autowired
    private WikiApiClient wikiApiClient;

    public List<String> getLinksToThePagesDescribingFootballClub(String footballClubName) {
        WikiApiResponse response = wikiApiClient.getPagesContainingSearchPhrase(footballClubName);
        List<String> links = obtainPagesDescribingFootballClub(response);
        return links;
    }

    private List<String> obtainPagesDescribingFootballClub(WikiApiResponse wikiApiResponse) {
        List<String> pagesDescribingFootballClub = wikiApiResponse.getQuery().getSearch().stream()
                .filter(PageInfo::doesPageDescribeFootballClub)
                .map(PageInfo::underscoreTitle)
                .map(underscoredTitle -> WIKIPEDIA_URL + underscoredTitle)
                .collect(Collectors.toList());
        return pagesDescribingFootballClub;
    }
}