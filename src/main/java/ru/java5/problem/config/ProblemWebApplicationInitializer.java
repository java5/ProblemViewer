package ru.java5.problem.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.security.config.BeanIds;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Зайнуллин Радик
 */
public class ProblemWebApplicationInitializer implements WebApplicationInitializer {
  private static final Class<?>[] configurationClasses = new Class<?>[]{
    ViewConfiguration.class, WebMvcContextConfiguration.class, DataConfigProduction.class, DataConfigDevelopment.class,
    SecurityConfig.class
  };

  @Override
  public void onStartup(final ServletContext servletContext) throws ServletException {
    registerListener(servletContext);
    registerDispatcherServlet(servletContext);
    registerSpringSecurityFilterChain(servletContext);
  }

  private void registerListener(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext rootContext = createContext(configurationClasses);
    servletContext.addListener(new ContextLoaderListener(rootContext));
    servletContext.addListener(new RequestContextListener());
  }

  private void registerDispatcherServlet(final ServletContext servletContext) {
    WebApplicationContext dispatcherContext = createContext(WebMvcContextConfiguration.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("*.htm");
  }

  /**
   * Factory method to create {@link AnnotationConfigWebApplicationContext} instances.
   * @param annotatedClasses
   */
  private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(annotatedClasses);
    return context;
  }

  private void registerSpringSecurityFilterChain(ServletContext servletContext) {
    FilterRegistration.Dynamic springSecurityFilterChain =
            servletContext.addFilter(BeanIds.SPRING_SECURITY_FILTER_CHAIN, new DelegatingFilterProxy());
    springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
  }
}