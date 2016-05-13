package com.tpfinal.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonParser {

    private static final Logger logger = LoggerFactory.getLogger(JsonParser.class);

    public static String parse(Object objetToParse){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(objetToParse);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        return "No se puede parsear a JSON el objeto ";
    }

}
