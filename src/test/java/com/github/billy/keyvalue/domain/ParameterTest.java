package com.github.billy.keyvalue.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.billy.keyvalue.type.Key;
import com.github.javafaker.Faker;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class ParameterTest {

  public static Key key;

  @Test
  void canCreateInstance() {
    assertThat(buildInstance()).isInstanceOf(Parameter.class);
  }

  public static Parameter buildInstance() {
    Faker faker = Faker.instance();
    key = Key.of(faker.backToTheFuture().character());

    Set<String> emailSet = new HashSet<>();
    emailSet.add(faker.internet().emailAddress());
    emailSet.add(faker.internet().emailAddress());
    emailSet.add(faker.internet().emailAddress());

    return new Parameter(key, emailSet);
  }
}