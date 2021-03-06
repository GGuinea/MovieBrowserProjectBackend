package movie.movieShow;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CORSFilter{

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost")
                        .allowedMethods("*");
                registry.addMapping("/*/*")
                        .allowedOrigins("http://localhost")
                        .allowedMethods("*");
            }
        };
    }
}
