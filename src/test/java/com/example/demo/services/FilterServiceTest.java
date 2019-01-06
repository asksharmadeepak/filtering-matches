package com.example.demo.services;

import com.example.demo.entity.City;
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
        List<Match> matches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"" ,
                0.76, 2, true, "Atheist"),new Match("Sharon",
                47, "Doctor", 161, new City(), "http://thecatapi.com/api/images/get?format=src&type=gif",
                0.97, 0, false, "Islam")) ;
        List<Match> expectedMatches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"http://thecatapi.com/api/images/get?format=src&type=gif" ,
                0.76, 2, true, "Atheist")) ;
        List<Match> actualMatchesResponse = filterService.refineMatches(matches, "", "photo");

        Assert.assertEquals(1 , actualMatchesResponse.size());
    }

    @Test
    public void shouldRefineMatchesForScore() throws Exception {
        List<Match> matches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"http://thecatapi.com/api/images/get?format=src&type=gif" ,
                0.76, 2, true, "Atheist"),new Match("Sharon",
                47, "Doctor", 161, new City(), "http://thecatapi.com/api/images/get?format=src&type=gif",
                0.18, 0, false, "Islam")) ;
        List<Match> expectedMatches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"http://thecatapi.com/api/images/get?format=src&type=gif" ,
                0.76, 2, true, "Atheist")) ;
        List<Match> actualMatchesResponse = filterService.refineMatches(matches, "0.28", "score");

        Assert.assertEquals(1 , actualMatchesResponse.size());
        Assert.assertEquals(expectedMatches.get(0).getDisplayName() , actualMatchesResponse.get(0).getDisplayName());

    }

}
