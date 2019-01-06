package com.example.demo.services;

import com.example.demo.entity.Match;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    private List<Match> getMatchesForScore(List<Match> matches, String value) {
        return matches.stream().filter(match -> match.getCompatibilityScore() >= Double.parseDouble(value)).collect(Collectors.toList());
    }

    private List<Match> getMatchesForPhoto(List<Match> matches) {
        return matches.stream().filter(match -> match.getMainPhoto() != null && !match.getMainPhoto().isEmpty() && !match.getMainPhoto().equals("Not available")).collect(Collectors.toList());
    }

    private List<Match> getMatchesForInContact(List<Match> matches) {
        return matches.stream().filter(match -> match.getContactsExchanged() != 0).collect(Collectors.toList());
    }

    private List<Match> getMatchesForFavourite(List<Match> matches) {
        return matches.stream().filter(match -> match.getFavourite()).collect(Collectors.toList());
    }

    private List<Match> getMatchesForHeight(List<Match> matches, String value) {
        return matches.stream().filter(match -> match.getHeightInCm() >= Integer.parseInt(value)).collect(Collectors.toList());
    }

    private List<Match> getMatchesForAge(List<Match> matches, String value) {
        return matches.stream().filter(match -> match.getAge() >= Integer.parseInt(value)).collect(Collectors.toList());
    }

}
