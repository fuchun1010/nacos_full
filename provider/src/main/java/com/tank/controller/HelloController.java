package com.tank.controller;

import com.tank.api.constants.UrlPrefix;
import com.tank.api.protocol.CustomerBody;
import io.vavr.control.Try;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tank198435163.com
 */
@RestController
@RequestMapping(UrlPrefix.URL_PREFIX_FOR)
public class HelloController {

  @GetMapping("/hello")
  public ResponseEntity<CustomerBody> sayHello() {
    return Try.of(() -> {
      val customerBody = new CustomerBody();
      customerBody.addValue("welcome", "hello,consumer");
      return customerBody;
    }).map(ResponseEntity::ok).getOrElseThrow(() -> new RuntimeException("some unknown server error"));
  }
}
