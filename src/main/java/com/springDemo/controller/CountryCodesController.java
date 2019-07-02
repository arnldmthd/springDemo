package com.springDemo.controller;

import com.springDemo.service.RestCountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.model.CountryCodesReformated;

@RestController
public class CountryCodesController {

    @Autowired
    private RestCountriesService restCountriesService;

    @RequestMapping(value = "/country_codes", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public CountryCodesReformated all() {
        return restCountriesService.getCountryCodes();
    }

}


