package com.springDemo.controller;

import com.springDemo.service.RestCountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.model.Capital;

@RestController
public class CapitalController {

    @Autowired
    private RestCountriesService restCountriesService;

    @RequestMapping(value = "/capital/{countryCode}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public Capital byCountryCode(@PathVariable("countryCode") String countryCode) {
        return restCountriesService.getCapitalByContryCode(countryCode);
    }
}


