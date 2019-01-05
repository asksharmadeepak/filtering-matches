package com.example.demo.controllers;

import com.example.demo.entity.Match;
import com.example.demo.services.MatchService;
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
public class MatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MatchService matchService;


    @Test
    public void shouldRetrieveHomePage() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }


    @Test
    public void shouldRetrieveAllMatches() throws Exception {
        List<Match> matches = Arrays.asList(new Match(),new Match()) ;
        Mockito.when(matchService.findAllMatch()).thenReturn(matches);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/matches");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}
