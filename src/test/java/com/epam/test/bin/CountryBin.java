package com.epam.test.bin;

import lombok.Getter;

public class CountryBin {
    public CountryBin(String name, String alpha2code, String capital, String region) {
        this.name = name;
        this.alpha2code = alpha2code;
        this.capital = capital;
        this.region = region;
    }

    @Getter
    private String name;
    @Getter
    private String alpha2code;
    @Getter
    private String capital;
    @Getter
    private String region;

}
