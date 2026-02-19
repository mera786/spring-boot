package com.app.repository;

import com.app.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather,Integer> {
     Optional<Weather> findByCity(String city);

    void deleteByCity(String city);
}
