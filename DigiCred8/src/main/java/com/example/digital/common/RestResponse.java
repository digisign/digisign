package com.example.digital.common;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class RestResponse {

    private Map<String,Object> results = new LinkedHashMap<>();

    /**
     * This method sets up the actual response of rest end points.
     * @param key   the key to identify whether the response is for success or error case.
     * @param value the value is actual response body in case of success and error message in case of failure.
     */
    @JsonAnySetter
    public void add(String key, Object value) {
        results.put(key, value);
    }

    /**
     * Gets resultant map
     * @return the results
     */
    @JsonAnyGetter
    public Map<String,Object> getResults() {
        return results;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RestResponse{");
        sb.append(", results=").append(results);
        sb.append('}');
        return sb.toString();
    }

}
