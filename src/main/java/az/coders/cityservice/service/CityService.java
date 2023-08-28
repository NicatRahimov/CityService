package az.coders.cityservice.service;

import az.coders.cityservice.model.City;

import java.util.List;

public interface CityService {
    List<City> getCities(String name);

     City createCity(City city);

     void deleteCity(Long id);

     City getCityById(Long id);

    void updateCity(City city, Long id);
}
