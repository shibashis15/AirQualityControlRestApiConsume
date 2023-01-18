package com.consumingRestAQI.AQI.Service;

import com.consumingRestAQI.AQI.Model.JsonFetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service("AirQualityServiceImpl" )
public class AirQualityServiceImpl  {
    @Autowired
    RestTemplate restTemplate;
    private String url = "https://api.waqi.info/feed/city/?token=73eb372f9a9b09fe5d0eae4751dcbf962b03dddd";
    public JsonFetch fetchAirQualityByCity(String city) {
        String temp  = url.replace("city" , city);
        System.out.println(temp);
        try {
            JsonFetch jsonFetch = restTemplate
                    .getForObject(temp, JsonFetch.class);
            System.out.println(jsonFetch.toString());
            return jsonFetch;
        }
        catch (RuntimeException runtimeException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status will be NOT FOUND (CODE 404)\n");
        }
    }
}
