package com.example.demo.services;

import com.example.demo.entity.Match;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsm2061 on 12/3/18.
 */

@Service
public class FilterService {

    public List<Match> refineMatches(List<Match> matches, String value, String filterName) {
        switch (filterName) {
            case "photo":
                return getMatchesForPhoto(matches);
            case "inContact":
                return getMatchesForInContact(matches);
            case "favourite":
                return getMatchesForFavourite(matches);
            case "score":
                return getMatchesForScore(matches, value);
            case "age":
                return getMatchesForAge(matches, value);
            case "height":
                return getMatchesForHeight(matches, value);
            default:
                return matches;
        }
    }

    private List<Match> getMatchesForHeight(List<Match> matches, String value) {
        List<Match> finalList = new ArrayList<>();
        for (Match match : matches) {
            if (match.getHeightInCm() >= Integer.parseInt(value)) {
                finalList.add(match);
            }
        }
        return finalList;
    }

    private List<Match> getMatchesForAge(List<Match> matches, String value) {
        List<Match> finalList = new ArrayList<>();
        for (Match match : matches) {
            if (match.getAge() >= Integer.parseInt(value)) {
                finalList.add(match);
            }
        }
        return finalList;
    }

    private List<Match> getMatchesForScore(List<Match> matches, String value) {
        List<Match> finalList = new ArrayList<>();
        for (Match match : matches) {
            if (match.getCompatibilityScore() >= Double.parseDouble(value)) {
                finalList.add(match);
            }
        }
        return finalList;
    }

    private List<Match> getMatchesForPhoto(List<Match> matches) {
        List<Match> finalList = new ArrayList<>();
        for (Match match : matches) {
            if (match.getMainPhoto() != null && !match.getMainPhoto().isEmpty() && !match.getMainPhoto().equals("Not available"))  {
                finalList.add(match);
            }
        }
        return finalList;
    }

    private List<Match> getMatchesForInContact(List<Match> matches) {
        List<Match> finalList = new ArrayList<>();
        for (Match match : matches) {
            if (match.getContactsExchanged() != 0) {
                finalList.add(match);
            }
        }
        return finalList;
    }

    private List<Match> getMatchesForFavourite(List<Match> matches) {
        List<Match> finalList = new ArrayList<>();
        for (Match match : matches) {
            if (match.getFavourite()) {
                finalList.add(match);
            }
        }
        return finalList;
    }


}
