package com.footballclub.finder.controller;

import java.util.List;

import com.footballclub.finder.service.PagesFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/finder-api/v1")
public class FinderController {

    @Autowired
    private PagesFinder pagesFinder;

    @GetMapping("/football-clubs")
    public List<String> getLinksToThePagesDescribingFootballClub(
            @RequestParam(value = "name") String footballClubName) {
        return pagesFinder.getLinksToThePagesDescribingFootballClub(footballClubName);
    }
}