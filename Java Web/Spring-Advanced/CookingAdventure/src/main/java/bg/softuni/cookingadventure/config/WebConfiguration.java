package bg.softuni.cookingadventure.config;

import bg.softuni.cookingadventure.interceptor.LoginCounterInterceptor;
import bg.softuni.cookingadventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final UserService userService;

    @Autowired
    public WebConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCounterInterceptor(userService));
    }
}
