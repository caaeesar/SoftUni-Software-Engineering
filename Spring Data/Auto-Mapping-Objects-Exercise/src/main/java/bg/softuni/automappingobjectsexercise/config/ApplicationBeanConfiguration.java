package bg.softuni.automappingobjectsexercise.config;

import bg.softuni.automappingobjectsexercise.model.dto.game.GameAddDto;
import bg.softuni.automappingobjectsexercise.model.entity.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper createModelMapper() {
        ModelMapper mapper = new ModelMapper();
        Converter<String, LocalDate> stringToLocalDateConverter = context -> LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        PropertyMap<GameAddDto, Game> propertyMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setImageThumbnail(source.getThumbnailURL());
            }
        };
        Converter<LocalDate, String> localDateToStringConverter = context -> context.getSource().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        mapper.addMappings(propertyMap);
        mapper.addConverter(stringToLocalDateConverter);
        mapper.addConverter(localDateToStringConverter);
        return mapper;
    }

    @Bean
    public Scanner createScanner() {
        return new Scanner(System.in);
    }

}
