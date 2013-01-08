package ru.java5.problem.config;

import javax.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * Configures Spring MVC.
 *
 * @author Marten Deinum
 * @author Koen Serneels
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ru.java5.problem"})
@PropertySource("classpath:application.properties")
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
  private static final String PROPERTY_NAME_MESSAGESOURCE_BASENAME = "message.source.basename";
  private static final String PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE = "message.source.use.code.as.default.message";  
  
  @Resource
  private Environment environment;  

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**/*").addResourceLocations("classpath:/META-INF/web-resources/");
  }

  @Override
  public void addViewControllers(final ViewControllerRegistry registry) {
    registry.addViewController("/index.htm").setViewName("index");
  }

  @Override
  public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new CookieLocaleResolver();
  }


  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

    messageSource.setBasename(environment.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_BASENAME));
    messageSource.setUseCodeAsDefaultMessage(Boolean.parseBoolean(environment.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE)));

    return messageSource;
  }
}