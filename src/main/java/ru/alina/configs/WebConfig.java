package ru.alina.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.alina.converter.StringToActivityConverter;
import ru.alina.converter.StringToGenderConverter;
import ru.alina.converter.StringToLocalDateConverter;

@Configuration
@ComponentScan(basePackages = "ru.alina.web")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**", "/resources/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/", "/resources/")
                .resourceChain(false);

    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToActivityConverter());
        registry.addConverter(new StringToGenderConverter());
        registry.addConverter(new StringToLocalDateConverter());
    }
}
