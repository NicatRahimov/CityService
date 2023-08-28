package az.coders.cityservice.service;

import az.coders.cityservice.exception.CityNotFoundException;
import az.coders.cityservice.model.City;
import az.coders.cityservice.repository.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    @Override
    public List<City> getCities(String name){
        if (name == null) {
         return cityRepository.findAll();
        }else {
           return cityRepository.findByName(name);
        }
    }
    @Override
    @Transactional
    public City createCity(City city) {
        city.setCreateDate(new Date());
      return cityRepository.save(city);
    }
    @Override
    public void deleteCity(Long id) {
cityRepository.deleteById(id);
    }
    @Override
    public City getCityById(Long id) {
        try {
            Optional<City> cityOptional = cityRepository.findById(id);
                return cityOptional.get();
        }catch (Exception e){
            throw new CityNotFoundException("City not found");
        }

    }

    @Override
    public void updateCity(City city, Long id) {
        City oldCity = getCityById(id);
        oldCity.setName(city.getName());
        cityRepository.save(oldCity);
    }
}
