package com.tank.protocol.inner;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
public class Person implements Serializable {

  private String name;

  private Integer gender;

  private int grade;
}
