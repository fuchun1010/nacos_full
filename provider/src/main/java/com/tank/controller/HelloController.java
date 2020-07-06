package com.tank.controller;

import com.tank.api.protocol.CustomerBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tank198435163.com
 */
@RestController
@RequestMapping("/service/api/v1")
public class HelloController {

  @GetMapping("/hello")
  public ResponseEntity<CustomerBody> sayHello() {
    CustomerBody customerBody = new CustomerBody();
    customerBody.addValue("hello", "hello,consumer");
    return ResponseEntity.ok(customerBody);
  }
}
