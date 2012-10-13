package com.syamantakm.thymeleaf.xml;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syamantak Mukhopadhyay
 */
public class Model {

    private Map<String, Object> fields = new HashMap<String, Object>();

    public void put(String key, Object value) {
        fields.put(key, value);
    }

    public Map<String, Object> getFields() {
        return fields;
    }
}
