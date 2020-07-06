package com.tank.api.protocol;

import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tank198435163.com
 */
public class CustomerBodyTest {

  @Test
  public void responseBodyWorkNormalTest() {
    boolean result = this.responseBody.addValue("address", JSON_VALUE);
    Assert.assertTrue(result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void responseBodyEmptyJsonKeyTest() {
    boolean result = this.responseBody.addValue("", JSON_VALUE);
    Assert.assertFalse(result);
  }

  @Test
  public void responseBodyAddDuplicateKey() {
    val result = this.responseBody.addValue("address", JSON_VALUE);
    Assert.assertTrue(result);
    val resultAgain = this.responseBody.addValue("address", JSON_VALUE);
    Assert.assertFalse(resultAgain);
  }

  @Before
  public void initResponseBody() {
    this.responseBody = new CustomerBody();
  }

  private CustomerBody responseBody;

  private static final String JSON_VALUE = "Cq";

}