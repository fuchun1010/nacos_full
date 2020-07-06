package com.tank.controller;

import com.tank.api.constants.UrlPrefix;
import com.tank.api.protocol.ResponseBody;
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

  @GetMapping("/sayHello")
  public ResponseEntity<ResponseBody> sayHello() {
    ResponseBody payload = new ResponseBody();
    payload.addValue("consumer", "hello,consumer");
    return ResponseEntity.ok(payload);
  }
}
