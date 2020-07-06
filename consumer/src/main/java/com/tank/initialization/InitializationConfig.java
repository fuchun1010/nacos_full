package com.tank.initialization;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author tank198435163.com
 */
@Configuration
public class InitializationConfig {

  @Bean
  @LoadBalanced
  public RestTemplate initRestTemplate() {
    return new RestTemplate();
  }

}
