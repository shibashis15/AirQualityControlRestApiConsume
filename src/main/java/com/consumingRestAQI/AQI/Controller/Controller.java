package com.consumingRestAQI.AQI.Controller;


import com.consumingRestAQI.AQI.ExceptionHandler.RecordNotFoundException;
import com.consumingRestAQI.AQI.Model.JsonFetch;
import com.consumingRestAQI.AQI.Service.AirQualityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1")
public class Controller {
    @Autowired
    AirQualityServiceImpl airQualityService;
    @GetMapping("/{city}")
    public ResponseEntity<JsonFetch> getAirQualityByCity(@PathVariable String city) throws RecordNotFoundException {

        JsonFetch jsonFetch = airQualityService.fetchAirQualityByCity(city);
        return  new ResponseEntity<JsonFetch>(jsonFetch , HttpStatus.OK);
    }

}
