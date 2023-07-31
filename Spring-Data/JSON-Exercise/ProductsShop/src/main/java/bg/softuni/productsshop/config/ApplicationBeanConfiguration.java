package bg.softuni.productsshop.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson createGson() {
        return new GsonBuilder()
               // .excludeFieldsWithoutExposeAnnotation()// only fields with @Expose
                //.serializeNulls()
                .setPrettyPrinting() // print with format
                .create();
    }

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }


}
