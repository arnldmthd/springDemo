package com.springDemo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.springDemo.model.CountryCodesReformated;
import com.springDemo.service.RestCountriesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import com.springDemo.model.Capital;
import com.springDemo.model.CountryCodes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestCountriesServiceTest {
    @Autowired
    private RestCountriesService restCountriesService;

    @MockBean
    private RestTemplate template;

    @Test
    public void CapitalApiTest() throws IOException {

        // Mock Up
        Capital expectedResponse = new Capital();
        expectedResponse.set("Finland", "Helsinki");
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity(expectedResponse, HttpStatus.OK));

        // Testing Service
        Capital result = restCountriesService.getCapitalByContryCode("FI");
        assertThat(result.name == "Finland").isTrue();
        assertThat(result.capital == "Helsinki").isTrue();
    }
    @Test
    public void CountryCodesApiTest() throws IOException {

        // Mock Up
        CountryCodes finland = new CountryCodes();
        finland.setAlpha2Code("FI");
        CountryCodes[] expectedResponse = new CountryCodes[] { finland };
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity(expectedResponse, HttpStatus.OK));

        // Testing Service
        CountryCodesReformated result = restCountriesService.getCountryCodes();
        assertThat(result.country_codes).hasSize(1);
        assertThat(result.country_codes).contains("FI");

    }
}
