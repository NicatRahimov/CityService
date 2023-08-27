package az.coders.cityservice.service;

import az.coders.cityservice.model.City;

import java.util.List;

public interface CityService {
    public List<City> getCities();

    public City createCity(City city);

    public void deleteCity(Long id);

    public City getCityById(Long id);
}
