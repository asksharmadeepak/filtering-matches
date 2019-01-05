package com.example.demo.controllers;

import com.example.demo.entity.Match;
import com.example.demo.services.FilterService;
import com.example.demo.utils.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by deepak.
 */

@RestController
public class FilterController {

    @Autowired
    MatchController matchController;

    @Autowired
    FilterService filterService;

    @GetMapping(path = EndPoints.FILTERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Match> filter(@RequestParam(value = "isEnable", required = false) Boolean isEnable,
                              @RequestParam(value = "filterName", required = false) String filterName,
                              @RequestParam(value = "value", required = false) String value) {
        List<Match> matches = matchController.retrieveAllMatches();
        if (isEnable) {
            return filterService.refineMatches(matches, value, filterName);
        } else {
            return matches;
        }
    }


}
