package com.github.billy.keyvalue.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class ParameterJpaEntityTest {

  public static String key;

  @Test
  void canCreateInstance() {
    assertThat(buildInstance()).isInstanceOf(ParameterJpaEntity.class);
  }

  public static ParameterJpaEntity buildInstance() {
    Faker faker = Faker.instance();

    ParameterJpaEntity entity = new ParameterJpaEntity();
    entity.setId(faker.number().randomNumber());
    key = faker.internet().avatar();

    Set<String> values = new HashSet<>();
    values.add(faker.internet().emailAddress());
    values.add(faker.internet().emailAddress());
    values.add(faker.internet().emailAddress());

    entity.setKey(key);
    entity.setValues(values);

    return entity;
  }
}