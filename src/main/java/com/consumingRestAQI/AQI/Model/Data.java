package com.consumingRestAQI.AQI.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(int aqi , City city) {
}
