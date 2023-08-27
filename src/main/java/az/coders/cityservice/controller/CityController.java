package az.coders.cityservice.controller;

import az.coders.cityservice.model.City;
import az.coders.cityservice.service.CityService;
import az.coders.cityservice.service.CityServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/cities")
@AllArgsConstructor
public class CityController {
    private final CityService cityService;


    @GetMapping
    public ResponseEntity<List<City>> getCities() {
        return new ResponseEntity<>(cityService.getCities(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable Long id) {
        City city1 = getCityById(id);
        return new ResponseEntity<>(city1, OK);
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.createCity(city), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCity(@PathVariable Long id, @RequestBody City city) {
        City oldCity = getCityById(id);
        oldCity.setName(city.getName());
        oldCity.setCreateDate(new Date());
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(OK);
    }


    private City getCityById(Long id) {
        return cityService.getCityById(id);
    }
}
