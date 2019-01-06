package com.example.demo.controllers;

import com.example.demo.entity.City;
import com.example.demo.entity.Match;
import com.example.demo.services.FilterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class FilterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilterService filterService;

    @MockBean
    MatchController matchController;

    @Test
    public void shouldReturnAllMatchesWhenNoFilterIsSelected() throws Exception {
        List<Match> matches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"http://thecatapi.com/api/images/get?format=src&type=gif" ,
                0.76, 2, true, "Atheist"),new Match("Sharon",
                47, "Doctor", 161, new City(), "http://thecatapi.com/api/images/get?format=src&type=gif",
                0.97, 0, false, "Islam")) ;
        when(matchController.retrieveAllMatches()).thenReturn(matches);
        when(filterService.refineMatches(matches, "", "")).thenReturn(matches);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/filters").param("isEnable", "true");
        mockMvc.perform(requestBuilder).andReturn();

        verify(filterService, times(1)).refineMatches(matches, null, null);
        verify(matchController, times(1)).retrieveAllMatches();
    }

    @Test
    public void shouldReturnRefineMatchesWhenFilterIsSelected() throws Exception {
        List<Match> matches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"http://thecatapi.com/api/images/get?format=src&type=gif" ,
                0.76, 2, true, "Atheist"),new Match("Sharon",
                47, "Doctor", 161, new City(), "http://thecatapi.com/api/images/get?format=src&type=gif",
                0.97, 0, false, "Islam")) ;
        List<Match> expectedMatches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"http://thecatapi.com/api/images/get?format=src&type=gif" ,
                0.76, 2, true, "Atheist")) ;

        Mockito.when(matchController.retrieveAllMatches()).thenReturn(matches);
        Mockito.when(filterService.refineMatches(matches, "", "haPhoto")).thenReturn(expectedMatches);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/filters").param("isEnable", "true");;
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        verify(filterService, times(1)).refineMatches(matches, null, null);
        verify(matchController, times(1)).retrieveAllMatches();

    }

}
