package ru.devmark.service;

import ru.devmark.entity.Country;
import ru.devmark.request.CountryRequest;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    Country getById(int id);

    Country getByName(String name);

    Country create(CountryRequest request);

    Country update(int id, CountryRequest request);

    void delete(int id);
}
