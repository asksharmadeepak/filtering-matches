package com.example.demo.mapper;

import com.example.demo.entity.City;
import com.example.demo.entity.Match;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dsm2061 on 12/3/18.
 */
@Component
public class MatchMapper {

    public  List<Match> mapToEntity() {
        List listOfMatches = new ArrayList();
        try {
            File file = ResourceUtils.getFile("classpath:matches.json");
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> matches = mapper.readValue(file, new TypeReference<Map<String, Object>>() {});
            ArrayList matchesArray = ((ArrayList)matches.get("matches"));

            for (int i = 0; i < matchesArray.size() ; i++) {
                LinkedHashMap<String, Object> matchesMapObject = (LinkedHashMap) matchesArray.get(i);
                Match match = new Match();
                match.setDisplayName(matchesMapObject.get("display_name").toString());
                match.setAge((Integer)matchesMapObject.get("age"));
                match.setJobTitle(matchesMapObject.get("job_title").toString());
                match.setHeightInCm((Integer)matchesMapObject.get("height_in_cm"));
                match.setCity(populateCity(matchesMapObject));
                match.setMainPhoto(populatePhoto(matchesMapObject));
                match.setCompatibilityScore((Double)matchesMapObject.get("compatibility_score"));
                match.setContactsExchanged((Integer)matchesMapObject.get("contacts_exchanged"));
                match.setFavourite((Boolean)matchesMapObject.get("favourite"));
                match.setReligion(matchesMapObject.get("religion").toString());
                listOfMatches.add(match);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfMatches;
    }

    private String populatePhoto(LinkedHashMap matchesMapObject) {
        if(matchesMapObject.get("main_photo") != null && matchesMapObject.get("main_photo") != ""){
            return matchesMapObject.get("main_photo").toString();
        }else{
            return "Not available";
        }
    }

    private City populateCity(LinkedHashMap cityHashMap) {
        City city =  new City();
        LinkedHashMap<String, String>  cityMap = (LinkedHashMap) cityHashMap.get("city");
        city.setName(cityMap.get("name"));
        //city.setLat(new BigDecimal(cityMap.get("lat")));
        //city.setLon(new BigDecimal(cityMap.get("lon")));
        return city;
    }

}
