package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;
import softuni.exam.util.XmlParserImpl;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper createModelMapper() {

        return new ModelMapper();
    }

    @Bean
    public Gson createGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public XmlParser createXmlParser() {
        return new XmlParserImpl();
    }

    @Bean
    public ValidationUtil createValidationUtil() {
        return new ValidationUtilImpl();
    }

}
