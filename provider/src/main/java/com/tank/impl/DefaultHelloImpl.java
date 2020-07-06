package com.tank.impl;

import com.tank.api.HelloService;
import io.vavr.control.Try;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class DefaultHelloImpl implements HelloService {
  @Override
  public Try<String> sayHello() {
    return Try.of(() -> "hello,consumer");
  }
}
