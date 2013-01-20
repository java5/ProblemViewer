package ru.java5.problem.config;

import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableJpaRepositories("ru.java5.problem.jpa.repository")
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = {
  "ru.java5.problem.jpa.controller",
  "ru.java5.problem.jpa.service"
})
@PropertySource("classpath:application.properties")
// @Resource()
//@Profile(value = "dev")
//@ImportResource("WEB-INF/problem-security.xml")
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
  private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
  private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
  private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
  private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
  private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
  @Resource
  private Environment environment;
  
  @Autowired
  private DataSource dataSource;

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    // registry.addResourceHandler("/styles/**").addResourceLocations("classpath:/WEB-INF/styles/");
    //registry.addResourceHandler("/resources/styles/**").addResourceLocations("/WEB-INF/styles/");
    //registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/").setCachePeriod(31556926);
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    
  }

  /**
   * Ensures that dispatcher servlet can be mapped to '/' and static resources are still served by the containers
   * default servlet.
   * @param configurer
   */
  @Override
  public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void addViewControllers(final ViewControllerRegistry registry) {
    registry.addViewController("/public/index.htm").setViewName("public/index");
    registry.addViewController("/public/problems.htm").setViewName("public/problems");
    registry.addViewController("/public/signin.htm").setViewName("/public/signin");
    
  }
  @Bean
  public HandlerInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("lang");
    return localeChangeInterceptor;
  }
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    InterceptorRegistration registration = registry.addInterceptor(localeChangeInterceptor());
    registration.addPathPatterns("/**");
  }
  @Bean
  public LocaleResolver localeResolver() {
    return new CookieLocaleResolver();
  }
  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames(new String[]{"WEB-INF/i18n/messages", "WEB-INF/i18n/application"});
    messageSource.setUseCodeAsDefaultMessage(true);
    return messageSource;
  }
  /** Configures the transaction manager. */
  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

  /** Configures the entity manager factory. */
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

    Properties jpaProperties = new Properties();
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

    entityManagerFactoryBean.setJpaProperties(jpaProperties);

    return entityManagerFactoryBean;
  }
  /** Configures the exception resolver. */
  @Bean
  public SimpleMappingExceptionResolver exceptionResolver() {
    SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();

    Properties exceptionMappings = new Properties();

    exceptionMappings.put("ru.java5.problem.jpa.service.NotFoundException", "error/404");
    exceptionMappings.put("java.lang.Exception", "error/error");
    exceptionMappings.put("java.lang.RuntimeException", "error/error");

    exceptionResolver.setExceptionMappings(exceptionMappings);

    Properties statusCodes = new Properties();

    statusCodes.put("error/404", "404");
    statusCodes.put("error/error", "500");

    exceptionResolver.setStatusCodes(statusCodes);

    return exceptionResolver;
  }
}