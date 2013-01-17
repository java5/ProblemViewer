package ru.java5.problem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

@Configuration
public class ViewConfiguration {
  /**
   * Configures Tiles at application startup.
   */
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer configurer = new TilesConfigurer();
    configurer.setDefinitions(new String[]{
              "/WEB-INF/layouts/layouts.xml",
              "/WEB-INF/views/**/views.xml"
            });
    
    configurer.setCheckRefresh(true);
    
    return configurer;
  }

  @Bean
  public TilesViewResolver tilesViewResolver() {
    TilesViewResolver tilesViewResolver = new TilesViewResolver();
    tilesViewResolver.setOrder(2);
    return tilesViewResolver;
  }
}