package bg.softuni.automappingobjectslab.config;

import bg.softuni.automappingobjectslab.model.dto.EmployeeViewDto;
import bg.softuni.automappingobjectslab.model.entity.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper createModelMapper() {
        ModelMapper mapper = new ModelMapper();
        PropertyMap<Employee, EmployeeViewDto> propertyMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setCity(source.getAddress().getCity().getName());
            }
        };
        mapper.addMappings(propertyMap);
        return mapper;
    }

}
