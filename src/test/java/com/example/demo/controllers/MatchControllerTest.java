package com.example.demo.controllers;

import com.example.demo.entity.City;
import com.example.demo.entity.Match;
import com.example.demo.services.MatchService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class MatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatchService matchService;

    @Test
    public void shouldRetrieveHomePage() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void shouldRetrieveAllMatches() throws Exception {
        List<Match> matches = Arrays.asList(new Match("Caroline", 41, "Lawyer", 123,
                new City(),"http://thecatapi.com/api/images/get?format=src&type=gif" ,
                0.76, 2, true, "Atheist"),new Match("Sharon",
                47, "Doctor", 161, new City(), "http://thecatapi.com/api/images/get?format=src&type=gif",
                0.97, 0, false, "Islam")) ;
        Mockito.when(matchService.findAllMatch()).thenReturn(matches);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/matches");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals("[{\"displayName\":\"Caroline\",\"age\":41,\"jobTitle\":\"Lawyer\",\"heightInCm\":123,\"city\":{\"name\":null,\"lat\":null,\"lon\":null},\"mainPhoto\":\"http://thecatapi.com/api/images/get?format=src&type=gif\",\"compatibilityScore\":0.76,\"contactsExchanged\":2,\"favourite\":true,\"religion\":\"Atheist\"},{\"displayName\":\"Sharon\",\"age\":47,\"jobTitle\":\"Doctor\",\"heightInCm\":161,\"city\":{\"name\":null,\"lat\":null,\"lon\":null},\"mainPhoto\":\"http://thecatapi.com/api/images/get?format=src&type=gif\",\"compatibilityScore\":0.97,\"contactsExchanged\":0,\"favourite\":false,\"religion\":\"Islam\"}]\n", result.getResponse().getContentAsString(), false);
    }
}