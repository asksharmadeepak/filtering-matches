package com.example.demo.services;

import com.example.demo.entity.Match;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilterServiceTest {


    @Autowired
    FilterService filterService;


    @Test
    public void shouldRefineMatchesForPhoto() throws Exception {
        List<Match> matches = Arrays.asList(new Match(),new Match()) ;
        List<Match> expectedMatches = Arrays.asList(new Match(),new Match()) ;

        List<Match> actualMatchesResponse = filterService.refineMatches(matches, "", "hasPhoto");

        Assert.assertEquals(expectedMatches , actualMatchesResponse);
    }

    @Test
    public void shouldRefineMatchesForScore() throws Exception {
        List<Match> matches = Arrays.asList(new Match(),new Match()) ;
        List<Match> expectedMatches = Arrays.asList(new Match(),new Match()) ;

        List<Match> actualMatchesResponse = filterService.refineMatches(matches, "0.28", "score");

        Assert.assertEquals(expectedMatches , actualMatchesResponse);
    }




}
