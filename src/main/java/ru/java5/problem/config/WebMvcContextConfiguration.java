package ru.java5.problem.config;

import javax.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Configures Spring MVC.
 *
 * @author 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ru.java5.problem"})
@PropertySource("classpath:application.properties")
@ImportResource("WEB-INF/problem-security.xml")
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
  @Resource
  private Environment environment;  

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**/*").addResourceLocations("classpath:/META-INF/web-resources/");
  }
  @Override
  public void addViewControllers(final ViewControllerRegistry registry) {
    registry.addViewController("/index.htm").setViewName("public/index");
  }
  @Override
  public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
  @Bean
  public HandlerInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("lang");
    return localeChangeInterceptor;
  }
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    InterceptorRegistration registration;
    registration = registry.addInterceptor(localeChangeInterceptor());
    registration.addPathPatterns("/**");
  }
  @Bean
  public LocaleResolver localeResolver() {
    return new CookieLocaleResolver();
  }
  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames(new String[]{ "WEB-INF/i18n/messages", "WEB-INF/i18n/application" });
    messageSource.setUseCodeAsDefaultMessage(true);
    return messageSource;
  }
}