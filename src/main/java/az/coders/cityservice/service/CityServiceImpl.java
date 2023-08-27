package az.coders.cityservice.service;

import az.coders.cityservice.model.City;
import az.coders.cityservice.repositories.CityRepository;
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
    public List<City> getCities(){
return cityRepository.findAll();
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
        Optional<City> cityOptional = cityRepository.findById(id);
     if (cityOptional.isPresent()){
         return cityOptional.get();
     }else throw new RuntimeException("City not found!");
    }
}
