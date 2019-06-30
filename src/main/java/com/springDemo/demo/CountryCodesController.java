package com.springDemo.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.CountryCodes;
import org.springframework.web.client.RestTemplate;

@RestController
public class CountryCodesController {
    @RequestMapping(value = "/country_codes", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public CountryCodes all() {
        CountryCodes countryCodes = new CountryCodes();

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity("https://restcountries.eu/rest/v2/all", String.class);
            JSONArray json = new JSONArray(response.getBody());
            for (int i = 0; i < json.length(); i++) {
                JSONObject obj = json.getJSONObject(i);
                countryCodes.add(obj.getString("alpha2Code"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return countryCodes;
    }
}