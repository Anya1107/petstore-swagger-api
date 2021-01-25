package by.sample.petstore.configuration;

import by.sample.petstore.interceptor.PetInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private PetInterceptor petInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(petInterceptor)
                .addPathPatterns("/pet/add")
                .addPathPatterns("/pet/delete")
                .addPathPatterns("/pet/getById")
                .addPathPatterns("/pet/getByStatus")
                .addPathPatterns("/pet/getALl")
                .addPathPatterns("/pet/update");
    }
}
