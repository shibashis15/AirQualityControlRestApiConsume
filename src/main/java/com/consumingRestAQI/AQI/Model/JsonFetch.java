package com.consumingRestAQI.AQI.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonFetch(String status , Data data){
}
