package com.tank.api.protocol;

import com.google.common.collect.Maps;
import io.vavr.control.Try;
import lombok.NonNull;
import lombok.val;

import java.util.Map;
import java.util.Objects;

/**
 * @author tank198435163.com
 */
public class ResponseBody {

  public <T> boolean addValue(@NonNull final String jsonKey, @NonNull final T jsonValue) {
    val dataKey = Try.of(() -> jsonKey).filter(key -> key.trim().length() > 0)
            .getOrElseThrow(() -> new IllegalArgumentException("jsonKey not allowed empty str"));
    val target = this.body.putIfAbsent(dataKey, jsonValue);
    return Objects.isNull(target);
  }

  private final Map<String, Object> body = Maps.newConcurrentMap();
}
