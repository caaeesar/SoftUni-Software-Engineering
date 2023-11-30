package bg.softuni.automappingobjectslab.service.impl;

import bg.softuni.automappingobjectslab.dao.CityRepository;
import bg.softuni.automappingobjectslab.model.entity.City;
import bg.softuni.automappingobjectslab.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepo;

    @Autowired
    public CityServiceImpl(CityRepository cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public void seedCity(City city) {
        this.cityRepo.saveAndFlush(city);
    }
}
