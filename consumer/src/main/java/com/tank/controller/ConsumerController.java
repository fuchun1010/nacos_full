package com.tank.controller;

import com.tank.api.protocol.CustomerBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.tank.api.constants.UrlPrefix.CONSUMER_URL_PREFIX_FOR;

/**
 * @author tank198435163.com
 */
@RestController
@RequestMapping(CONSUMER_URL_PREFIX_FOR)
public class ConsumerController {

  @GetMapping("/helloConsumer")
  public ResponseEntity<CustomerBody> helloConsumer() {
    return this.restTemplate.getForEntity("http://provider/service/api/v1/hello", CustomerBody.class);
  }

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LoadBalancerClient loadBalancerClient;

}
