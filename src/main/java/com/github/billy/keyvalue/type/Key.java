package com.github.billy.keyvalue.type;

import javax.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Key extends BaseType {

  @NotEmpty
  private final String value;

  private Key(String value) {
    this.value = value;
  }

  public static Key of(String value) {
    return new Key(value);
  }
}
