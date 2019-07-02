package com.springDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryCodes {
    public String alpha2Code;
    public void setAlpha2Code(String givenCode) {
        alpha2Code = givenCode;
    }
}
