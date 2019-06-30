package com.springDemo.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.Capital;
import org.springframework.web.client.RestTemplate;

@RestController
public class CapitalController {
    @RequestMapping(value = "/capital/{country_code}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Capital all(@PathVariable("country_code") String country_code) {
        Capital capital = new Capital();
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://restcountries.eu/rest/v2/alpha/" + country_code;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONObject obj = new JSONObject(response.getBody());
            capital.setName(obj.getString("name"));
            capital.setCapital(obj.getString("capital"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return capital;
    }
}


