package com.app.controller;

import com.app.entity.Weather;
import com.app.repository.WeatherRepository;
import com.app.service.CacheInspectionService;
import com.app.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CacheInspectionService cacheInspectionService;


    @GetMapping
    public String getWeatherByCity(@RequestParam String city){
        String weatherByCity = weatherService.getWeatherByCity(city);
        return weatherByCity;
    }




    @PostMapping
    public Weather addWeather(@RequestBody Weather weather){
        log.info("Saving weather data for city: {}", weather.getCity());
        Weather saved = weatherRepository.save(weather);
        log.info("Weather saved successfully with id: {}", saved.getId());
        return saved;
    }

    @GetMapping("/all")
    public List<Weather> getAllWeather(){
        return weatherRepository.findAll();
    }


    @GetMapping("/cacheData")
    public void getCacheData(){
        cacheInspectionService.printCacheContents("weather");
    }


    @PutMapping("/{city}")
    public String updateWeather(@PathVariable String city, @RequestParam String updatedWeather){
       return weatherService.updateWeather(city,updatedWeather);
    }


    @DeleteMapping("/{city}")
    public String deleteWeather(@PathVariable String city){
        weatherService.deleteWeather(city);
        return "weather data for "+city+ "has been deleted and cache evicted.";
    }

}
