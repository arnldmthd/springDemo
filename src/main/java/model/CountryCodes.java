package model;

import java.util.ArrayList;
import java.util.List;

public class CountryCodes {
    public List<String> country_codes = new ArrayList();
    public void add(String code) {
        country_codes.add(code);
    }
    public List<String> get() {
        return country_codes;
    }
}