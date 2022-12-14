package com.github.billy.keyvalue.type;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeyMapper {

  default String map(Key key) {
    return key.getValue();
  }

  default Key map(String value) {
    return Key.of(value);
  }
}