package workshop.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("workshop")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    @Override                                                                   //Spring pomija obrazki, pliki jpg, css, js
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); }



//    @Override                                                                   // ustawia odpowiednie encoding dla jezyka w ktorym mamy wyswietlac dane, special characters typu śżćłń
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
//        stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "html",
//                Charset.forName("UTF-8"))));
//        converters.add(stringConverter);
//    }

    @Bean                                                                      // ustawia prefix i suffix dla widokow zebysmy mogli w akcjach pisac "form" zamiast"/WEB-INF/form,jsp"
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
