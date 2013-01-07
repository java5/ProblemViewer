package ru.java5.problem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.java5.problem.IndexController;

/**
 * Spring MVC configuration
 * @author Зайнуллин Радик
 */
@Configuration
public class WebMvcContextConfiguration {
  @Bean
  public IndexController indexController() {
    return new IndexController();
  }
}