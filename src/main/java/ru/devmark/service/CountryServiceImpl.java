package ru.devmark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.devmark.dao.CountryDao;
import ru.devmark.entity.Country;
import ru.devmark.exception.NotFoundException;
import ru.devmark.request.CountryRequest;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> getAll() {
        return countryDao.findAllByOrderByIdDesc();
    }

    @Override
    public Country getById(int id) {
        Country country = countryDao.findOne(id);
        if (country == null) {
            throw new NotFoundException(id);
        }
        return country;
    }

    @Override
    public Country getByName(String name) {
        Country country = countryDao.findByName(name);
        if (country == null) {
            throw new NotFoundException(name);
        }
        return country;
    }

    @Override
    public Country create(CountryRequest request) {
        Country country = new Country();
        country.setName(request.getName());
        return countryDao.save(country);
    }

    @Override
    public Country update(int id, CountryRequest request) {
        if (!countryDao.exists(id)) {
            throw new NotFoundException(id);
        }
        Country country = new Country();
        country.setId(id);
        country.setName(request.getName());
        return countryDao.save(country);
    }

    @Override
    public void delete(int id) {
        if (!countryDao.exists(id)) {
            throw new NotFoundException(id);
        }
        countryDao.delete(id);
    }
}
