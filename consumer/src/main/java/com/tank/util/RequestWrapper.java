package com.tank.util;

import com.google.common.collect.Maps;
import io.vavr.control.Try;
import lombok.NonNull;
import lombok.val;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author tank198435163.com
 */
public class RequestWrapper {

  public <T> Try<T> toInstance(@NonNull final Map<String, String> payLoad, Class<T> clazz) {

    return Try.of(clazz::newInstance).map(instance -> {

      val methods = Maps.<String, Method>newHashMap();

      Stream.of(clazz.getDeclaredMethods())
              .filter(method -> method.getName().contains("set"))
              .filter(method -> {
                String setterName = method.getName().toLowerCase().substring(setterBegin);
                return payLoad.containsKey(setterName);
              })
              .forEach(method -> methods.putIfAbsent(method.getName().toLowerCase(), method));

      try {
        for (Map.Entry<String, Method> entry : methods.entrySet()) {
          val key = entry.getKey();
          val method = methods.get(key);
          val value = payLoad.get(key.substring(setterBegin));
          Class<?>[] params = method.getParameterTypes();
          if (params.length != 1) {
            continue;
          }
          val parameterClazz = params[0];
          //TODO 需要补充double,float,bigDecimal类型的判断
          if (parameterClazz == Integer.class || parameterClazz == int.class) {
            method.invoke(instance, Integer.parseInt(value));
          } else if (parameterClazz == String.class) {
            method.invoke(instance, value);
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      return instance;
    });


  }

  private final int setterBegin = 3;

}
