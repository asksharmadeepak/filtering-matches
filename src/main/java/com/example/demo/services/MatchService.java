package com.example.demo.services;

import com.example.demo.entity.Filter;
import com.example.demo.entity.Match;
import com.example.demo.mapper.MatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dsm2061 on 12/3/18.
 */

@Service
public class MatchService {


    @Autowired
    MatchMapper matchMapper;

    public List<Match> findAllMatch() {
        return matchMapper.mapToEntity();
    }
}
