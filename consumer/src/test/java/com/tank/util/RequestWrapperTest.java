package com.tank.util;

import com.tank.protocol.PayLoad;
import com.tank.protocol.inner.Person;
import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author tank198435163.com
 */
public class RequestWrapperTest {

  @Before
  public void init() {
    this.payLoad = new PayLoad();
    val nameField = new PayLoad.Field();
    nameField.setFieldName("name");
    nameField.setValue("lisi");

    val genderField = new PayLoad.Field();
    genderField.setFieldName("gender");
    genderField.setValue("1");

    val gradeField = new PayLoad.Field();
    gradeField.setFieldName("grade");
    gradeField.setValue("5");

    this.payLoad.setPayloads(Arrays.asList(nameField, gradeField, genderField));
  }

  @Test
  public void testToInstance() {
    val requestWrapper = new RequestWrapper();
    val body = this.payLoad.toMap();
    val personTry = requestWrapper.toInstance(body, Person.class);
    personTry.onSuccess(person -> {
      Assert.assertEquals(person.getGrade(), 5);
      Assert.assertEquals(person.getName(), "lisi");
    });

  }

  private PayLoad payLoad;
}