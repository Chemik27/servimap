package com.tpfinal.controller;

import com.tpfinal.domain.Work;
import com.tpfinal.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    WorkService workService;

    @RequestMapping(method = RequestMethod.POST)
    public Page<Work> getProduct(){
        logger.info("POST");
        return workService.findAll(new PageRequest(0, 10));
    }

}
