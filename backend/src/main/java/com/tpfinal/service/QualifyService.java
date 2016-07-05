package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.repository.IQualifyRepository;
import com.tpfinal.util.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by redbee on 05/07/16.
 */
@Service
public class QualifyService {

    @Autowired
    IQualifyRepository qualifyRepository;

    private static final Logger logger = LoggerFactory.getLogger(QualifyService.class);

    public List<Rating> findAll(){
        return qualifyRepository.findAll();
    }


    public void save(Rating rating){
        logger.debug(JsonParser.parse(rating));
        qualifyRepository.save(rating);
    }


}
