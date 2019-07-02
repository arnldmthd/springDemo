package com.springDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Capital {
    public String name;
    public String capital;
    public void set(String givenName, String givenCapital) {
        name = givenName;
        capital = givenCapital;
    }
}
