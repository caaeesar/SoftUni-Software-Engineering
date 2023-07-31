package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public ModelMapper createModelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }

    @Bean
    public Gson createGson() {
        return new GsonBuilder()
                //.excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }
}
