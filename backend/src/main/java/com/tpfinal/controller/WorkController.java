package com.tpfinal.controller;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.Category;
import com.tpfinal.domain.Work;
import com.tpfinal.service.UserService;
import com.tpfinal.service.WorkService;
import com.tpfinal.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/works/{workTyped}")
    @ResponseStatus(HttpStatus.OK)
    public List<Work> getWorks(@PathVariable String workTyped){
        List<Work> works = workService.findByName(workTyped);
        return works;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/worksByCategory/{idCategory}"})
    @ResponseStatus(HttpStatus.OK)
    public List<Work> getWorksByCategory(@PathVariable String idCategory){
        Long categorySelected = Long.valueOf(idCategory);
        Category category = (Category) Factory.create(new Category());
        category.setIdCategory(categorySelected);
        List<Work> works = workService.findByCategory(category);

        return works;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/worksByAddress/{idAddress}"})
    @ResponseStatus(HttpStatus.OK)
    public List<Work> getWorksByAddress(@PathVariable String idAddress){
        Long addressSelected = Long.valueOf(idAddress);
        Address address = (Address) Factory.create(new Address());
        address.setIdAddress(addressSelected);
        List<Work> works = workService.findByAddress(address);

        return works;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/worksByWordOfSearch/{wordOfSearchTyped}"})
    @ResponseStatus(HttpStatus.OK)
    public List<Work> getWorksByWordOfSearch(@PathVariable String wordOfSearchTyped){
        List<Work> works = workService.findByDescriptionContaining(wordOfSearchTyped);

        return works;
    }

}
