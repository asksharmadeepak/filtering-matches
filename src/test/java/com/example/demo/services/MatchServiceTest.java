package com.example.demo.services;

import com.example.demo.entity.City;
import com.example.demo.entity.Match;
import com.example.demo.mapper.MatchMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchServiceTest {

    @Mock
    MatchMapper matchMapper;

    @InjectMocks
    MatchService matchService;

    @Test
    public void shouldFindAllMatch() throws Exception {
        List<Match> matches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"http://thecatapi.com/api/images/get?format=src&type=gif" ,
                0.76, 2, true, "Atheist"),new Match("Sharon",
                47, "Doctor", 161, new City(), "http://thecatapi.com/api/images/get?format=src&type=gif",
                0.97, 0, false, "Islam")) ;
        when(matchMapper.mapToEntity()).thenReturn(matches);

        List<Match> actualMatchesResponse = matchService.findAllMatch();

        Assert.assertEquals(2 , actualMatchesResponse.size());
    }

}
