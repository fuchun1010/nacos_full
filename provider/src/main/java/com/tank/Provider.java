package com.tank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tank198435163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider {
  public static void main(final String[] args) {
    SpringApplication.run(Provider.class, args);
  }
}
