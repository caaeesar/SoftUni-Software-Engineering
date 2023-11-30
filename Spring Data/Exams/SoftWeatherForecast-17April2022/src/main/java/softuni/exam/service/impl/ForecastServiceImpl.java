package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastExportDto;
import softuni.exam.models.dto.ForecastRootSeedDto;
import softuni.exam.models.dto.ForecastSeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static softuni.exam.models.entity.enums.DayOfWeek.SUNDAY;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";
    private static final String SUCCESSFUL_MESSAGE = "Successfully import forecast %s - %.2f";
    private static final String INVALID_MESSAGE = "Invalid forecast";
    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, ModelMapper mapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        Converter<String, LocalTime> stringToLocalTimeConverter
                = context -> LocalTime.parse(context.getSource(), DateTimeFormatter.ofPattern("HH:mm:ss"));

        mapper.typeMap(ForecastSeedDto.class, Forecast.class).
                addMappings(mapper -> mapper.using(stringToLocalTimeConverter)
                        .map(ForecastSeedDto::getSunset, Forecast::setSunset));

        mapper.typeMap(ForecastSeedDto.class, Forecast.class).
                addMappings(mapper -> mapper.using(stringToLocalTimeConverter)
                        .map(ForecastSeedDto::getSunrise, Forecast::setSunrise));

        StringBuilder message = new StringBuilder();

        List<ForecastSeedDto> forecastSeedDtos = xmlParser.deserialize(ForecastRootSeedDto.class, Path.of(FORECAST_FILE_PATH).toFile())
                .getForecasts().stream().collect(Collectors.toList());

        for (ForecastSeedDto forecastSeedDto : forecastSeedDtos) {

            if (!isExistCityWithSameDayOfWeek(forecastSeedDto.getDayOfWeek(), forecastSeedDto.getCity())
                    && validationUtil.isValid(forecastSeedDto)) {

                Forecast forecast = mapper.map(forecastSeedDto, Forecast.class);
                City city = cityRepository.getById(forecastSeedDto.getCity());
                forecast.setCity(city);
                forecastRepository.save(forecast);
                message.append(String.format(SUCCESSFUL_MESSAGE, forecast.getDayOfWeek().name(), forecast.getMaxTemperature()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistCityWithSameDayOfWeek(DayOfWeek dayOfWeek, Long city) {
        return forecastRepository.findForecastByDayOfWeekAndCity_Id(dayOfWeek, city).isPresent();
    }

    @Override
    public String exportForecasts() {
        List<Forecast> forecasts = forecastRepository.findForecastsByDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc(SUNDAY, 150000);
        return forecasts.stream().map(forecast -> mapper.map(forecast, ForecastExportDto.class))
                .map(ForecastExportDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
