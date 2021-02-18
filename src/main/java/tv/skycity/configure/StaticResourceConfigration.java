package tv.skycity.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class StaticResourceConfigration implements WebMvcConfigurer {
    @Value("${user.file.path}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/resources/",
                "classpath:/static/",
                "classpath:/public/",
                "classpath:/webapp/",
                "file:/" + filePath + "/"
        );
    }
}
