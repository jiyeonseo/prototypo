package net.proto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jiyeonseo
 * Date: 14. 1. 28.
 * Time: 오후 3:33
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"net.jiyeon.pie", "net.jiyeon.twitter", "net.jiyeon.weathersound"})
@Import(RootConfiguration.class)
public class ServletConfiguration extends WebMvcConfigurerAdapter {
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }



    @Bean(name = "velocityConfig")
    public VelocityConfigurer velocityConfig() {
        VelocityConfigurer config = new VelocityConfigurer();
        config.setResourceLoaderPath("/WEB-INF/views/");

        Map<String, Object> velocityPropertiesMap = new HashMap<String, Object>();
        velocityPropertiesMap.put("input.encoding", "UTF-8");
        velocityPropertiesMap.put("output.encoding", "UTF-8");
        velocityPropertiesMap.put("velocimacro.library.autoreload", false);
        velocityPropertiesMap.put("directive.foreach.counter.initial.value", 0);
        velocityPropertiesMap.put("velocimacro.library.autoreload", false);
        config.setVelocityPropertiesMap(velocityPropertiesMap);
        return config;
    }

    @Bean
    public ContentNegotiatingViewResolver resolver() {
        Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
        mediaTypes.put("html", MediaType.TEXT_HTML);
        mediaTypes.put("json", MediaType.APPLICATION_JSON);

        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setOrder(1);
        resolver.setContentNegotiationManager(
                new ContentNegotiationManager(
                        new PathExtensionContentNegotiationStrategy(mediaTypes)
                )
        );
        resolver.setDefaultViews(defaultViews());
        resolver.setViewResolvers(viewResolvers());
        return resolver;
    }

    private List<View> defaultViews() {
        List<View> list = new ArrayList<View>();
        list.add(new MappingJacksonJsonView());
        return list;
    }

    private List<ViewResolver> viewResolvers() {
        VelocityViewResolver viewResolver = new VelocityViewResolver();
        viewResolver.setContentType("text/html; charset=UTF-8");
        viewResolver.setSuffix(".html");
        viewResolver.setRedirectHttp10Compatible(false);
        List<ViewResolver> list = new ArrayList<ViewResolver>();
        list.add(viewResolver);
        return list;
    }

}
