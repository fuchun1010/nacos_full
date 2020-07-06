package com.tank.api;

import io.vavr.control.Try;

/**
 * @author tank198435163.com
 */
public interface HelloService {

  /**
   * only say hello to some one
   *
   * @return
   */
  Try<String> sayHello();
}
