package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper createModelMapper() {

        ModelMapper mapper = new ModelMapper();

        Converter<String, LocalDate> stringToLocalDateConverter
                = context -> LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Converter<LocalDate, String> localDateToStringConverter = context -> context.getSource().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        mapper.addConverter(stringToLocalDateConverter);
        mapper.addConverter(localDateToStringConverter);

        return mapper;
    }

    @Bean
    public Gson createGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
}
