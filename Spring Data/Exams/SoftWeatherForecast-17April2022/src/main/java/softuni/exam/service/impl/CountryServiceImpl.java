package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported country %s - %s";
    private static final String INVALID_MESSAGE = "Invalid country";
    private final CountryRepository countryRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder message = new StringBuilder();

        List<CountrySeedDto> countrySeedDtos = Arrays.stream(gson.fromJson(readCountriesFromFile(), CountrySeedDto[].class)).collect(Collectors.toList());
        for (CountrySeedDto countrySeedDto : countrySeedDtos) {

            if (!isExistCountryWithName(countrySeedDto.getCountryName()) && validationUtil.isValid(countrySeedDto)) {
                Country country = mapper.map(countrySeedDto, Country.class);
                countryRepository.save(country);
                message.append(String.format(SUCCESSFUL_MESSAGE, country.getCountryName(), country.getCurrency()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistCountryWithName(String countryName) {
        return countryRepository.findCountryByCountryName(countryName).isPresent();
    }
}
