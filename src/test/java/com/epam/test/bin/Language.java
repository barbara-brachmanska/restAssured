
package com.epam.test.bin;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Language {

    private String iso6391;
    private String iso6392;
    private String name;
    private String nativeName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



}
