package az.coders.cityservice.controller;

import az.coders.cityservice.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
    private  List<City>cities;

    public CityController() {
        City city = new City(2L,"Baku",new Date());
        City city1 = new City(6L,"Sumqayit",new Date());
      cities = Arrays.asList(city,city1);
    }



    @GetMapping
    public ResponseEntity<List<City>> getCities(){
     return new ResponseEntity<>(cities, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") String cityId) {
        City city1 = cities.stream()
                .filter(city -> city.getId().equals(Long.parseLong(cityId)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("City is not eligible"));

        return new ResponseEntity<>(city1,OK);
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city){
        city.setCreateDate(new Date());
cities.add(city);

return new ResponseEntity<>(city,OK);
    }
}
