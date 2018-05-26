package ru.devmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.devmark.entity.Country;
import ru.devmark.request.CountryRequest;
import ru.devmark.service.CountryService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class GeoController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAll();
    }

    @GetMapping("/countries/{countryId:\\d+}")
    public Country getCountryById(@PathVariable("countryId") int id) {
        return countryService.getById(id);
    }

    @GetMapping("/countries/{countryName:\\D+}")
    public Country getCountryById(@PathVariable("countryName") String name) {
        return countryService.getByName(name);
    }

    @PostMapping("/countries")
    @ResponseStatus(HttpStatus.CREATED)
    public Country createCountry(@RequestBody CountryRequest request) {
        return countryService.create(request);
    }

    @PutMapping("/countries/{countryId}")
    public Country updateCountry(@PathVariable("countryId") int id, @RequestBody CountryRequest request) {
        return countryService.update(id, request);
    }

    @DeleteMapping("/countries/{countryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable("countryId") int id) {
        countryService.delete(id);
    }
}
