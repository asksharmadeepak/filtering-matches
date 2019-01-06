package com.example.demo.controllers;

import com.example.demo.entity.Match;
import com.example.demo.services.MatchService;
import com.example.demo.utils.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping(EndPoints.HOME)
    public String welcome(Model model) {
        model.addAttribute("match", new Match());
        return "home";
    }

    @GetMapping(path = EndPoints.MATCHES, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Match> retrieveAllMatches() {
        List<Match> matches= matchService.findAllMatch();
        return matches;
    }
}
