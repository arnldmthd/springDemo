package com.springDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryCodesReformated {
    public List<String> country_codes = new ArrayList();
    public void add(String code) {
        country_codes.add(code);
    }
}