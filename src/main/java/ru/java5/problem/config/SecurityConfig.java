package ru.java5.problem.config;

import com.springsource.greenhouse.account.GreenhousePasswordEncoder;
import javax.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@ImportResource("classpath:security.xml")
public class SecurityConfig {
  /**
   * Embedded Security configuration (not secure).
   * @author Keith Donald
   */
  @Configuration
  @Profile("embedded")
  static class Embedded {
    @Bean
    public PasswordEncoder passwordEncoder() {
      return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public TextEncryptor textEncryptor() {
      return Encryptors.noOpText();
    }
  }
  /**
   * Standard security configuration (secure).
   * @author Keith Donald
   */
  @Configuration
  @Profile("standard")
  static class Standard {
    @Inject
    private Environment environment;
    @Bean
    public PasswordEncoder passwordEncoder() {
      return new GreenhousePasswordEncoder(getEncryptPassword());
    }
    @Bean
    public TextEncryptor textEncryptor() {
      return Encryptors.queryableText(getEncryptPassword(), environment.getProperty("security.encryptSalt"));
    }
    // helpers
    private String getEncryptPassword() {
      return environment.getProperty("security.encryptPassword");
    }
  }
}