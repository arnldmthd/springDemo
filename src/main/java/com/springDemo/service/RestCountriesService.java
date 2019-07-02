package com.springDemo.service;

import com.springDemo.model.Capital;
import com.springDemo.model.CountryCodesReformated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.springDemo.model.CountryCodes;


@Service
public class RestCountriesService {

    @Autowired
    RestTemplate restTemplate;

    // Country Codes from https://restcountries.eu/rest/v2/all needs to be reformatted from CountryCodes to CountryCodesReformated

    public CountryCodesReformated getCountryCodes() {
        CountryCodesReformated countryCodesReformated = new CountryCodesReformated();
        try {
            String url = "https://restcountries.eu/rest/v2/all";
            ResponseEntity<CountryCodes[]> response = restTemplate.getForEntity(url, CountryCodes[].class);
            HttpStatus statusCode = response.getStatusCode();
            CountryCodes[] originData = response.getBody();
            for (CountryCodes item : originData) {
                countryCodesReformated.add(item.alpha2Code);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null; // Requires exception handler
        }
        return countryCodesReformated;
    }

    // Capitals can be returned as they are at https://restcountries.eu/rest/v2/alpha/fi

    public Capital getCapitalByContryCode(@PathVariable("country_code") String country_code) {
        try {
            String url = "https://restcountries.eu/rest/v2/alpha/" + country_code;
            ResponseEntity<Capital> response = restTemplate.getForEntity(url, Capital.class);
            HttpStatus statusCode = response.getStatusCode();
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null; // Requires exception handler
        }
    }
}
