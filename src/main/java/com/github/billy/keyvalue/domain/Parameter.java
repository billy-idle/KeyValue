package com.github.billy.keyvalue.domain;

import com.github.billy.keyvalue.type.Key;
import java.util.HashMap;
import java.util.Set;
import lombok.Getter;

@Getter
public class Parameter extends HashMap<Key, Set<String>> {

  public static final Key ADDRESSES = Key.of("addresses");

  public Parameter(Key key, Set<String> valueList) {
    super.put(key, valueList);
  }
}
