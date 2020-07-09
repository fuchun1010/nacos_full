package com.tank.protocol;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
public class PayLoad {

  @Getter
  @Setter
  public static class Field {
    private String fieldName;
    private String value;

    public boolean isValidate() {
      return Objects.nonNull(fieldName) && Objects.nonNull(value);
    }
  }

  public Map<String, String> toMap() {
    val result = Maps.<String, String>newHashMap();
    payloads.stream()
            .filter(Field::isValidate)
            .filter(data -> data.getValue().trim().length() > 0)
            .filter(data -> !"-".equalsIgnoreCase(data.getValue()))
            .collect(Collectors.toList())
            .forEach(data -> result.put(data.getFieldName().toLowerCase(), data.getValue()));
    return result;
  }

  private List<Field> payloads = Lists.newLinkedList();

}
