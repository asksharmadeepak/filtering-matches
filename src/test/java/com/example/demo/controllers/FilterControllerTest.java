package com.example.demo.controllers;

import com.example.demo.entity.Match;
import com.example.demo.services.FilterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FilterService filterService;

    @Autowired
    MatchController matchController;

    @Test
    public void shouldReturnAllMatchesWhenNoFilterIsSelected() throws Exception {
        List<Match> matches = Arrays.asList(new Match(),new Match()) ;

        Mockito.when(matchController.retrieveAllMatches()).thenReturn(matches);
        Mockito.when(filterService.refineMatches(Mockito.anyList(), Mockito.anyString(), Mockito.anyString())).thenReturn(matches);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/filters");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void shouldReturnRefineMatchesWhenFilterIsSelected() throws Exception {
        List<Match> matches = Arrays.asList(new Match(),new Match()) ;

        Mockito.when(matchController.retrieveAllMatches()).thenReturn(matches);
        Mockito.when(filterService.refineMatches(Mockito.anyList(), Mockito.anyString(), Mockito.anyString())).thenReturn(matches);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/filters");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}
