package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private static final String CITY_FILE_PATH = "src/main/resources/files/json/cities.json";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported city %s - %d";
    private static final String INVALID_MESSAGE = "Invalid city";
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITY_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder message = new StringBuilder();

        List<CitySeedDto> citySeedDtos = Arrays.stream(gson.fromJson(readCitiesFileContent(), CitySeedDto[].class)).collect(Collectors.toList());

        for (CitySeedDto citySeedDto : citySeedDtos) {

            if (!isExistCityWithName(citySeedDto.getCityName()) && validationUtil.isValid(citySeedDto)) {
                City city = mapper.map(citySeedDto, City.class);
                Country country = countryRepository.getById(citySeedDto.getCountry());
                city.setCountry(country);
                cityRepository.save(city);

                message.append(String.format(SUCCESSFUL_MESSAGE, city.getCityName(), city.getPopulation()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistCityWithName(String cityName) {
        return cityRepository.findCityByCityName(cityName).isPresent();
    }
}
