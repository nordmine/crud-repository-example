package ru.devmark.dao;

import org.springframework.data.repository.CrudRepository;
import ru.devmark.entity.Country;

import java.util.List;

public interface CountryDao extends CrudRepository<Country, Integer> {

    List<Country> findAllByOrderByIdDesc();

    Country findByName(String name);
}
