package com.github.billy.keyvalue.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.billy.keyvalue.domain.Parameter;
import com.github.billy.keyvalue.repository.ParameterJpaEntity;
import com.github.billy.keyvalue.repository.ParameterJpaEntityTest;
import com.github.billy.keyvalue.repository.ParameterRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ParameterMapperTest {

  @Autowired
  private ParameterRepository parameterRepository;

  @Autowired
  private ParameterMapper parameterMapper;

  @Test
  void canMapToParameter() {
    ParameterJpaEntity jpaEntity = ParameterJpaEntityTest.buildInstance();
    log.info("ParameterJpaEntity: {}", jpaEntity);
    Parameter parameter = parameterMapper.toDomain(jpaEntity);
    log.info("Parameter: {}", parameter);
    assertThat(parameter).isInstanceOf(Parameter.class);
  }

  @Test
  void canMapToListOfParameters() {
    List<ParameterJpaEntity> entities = new ArrayList<>();
    entities.add(ParameterJpaEntityTest.buildInstance());
    entities.add(ParameterJpaEntityTest.buildInstance());
    entities.add(ParameterJpaEntityTest.buildInstance());

    log.info("List of ParameterJpaEntities: {}", entities);

    List<Parameter> parameters = parameterMapper.toDomain(entities);

    log.info("List of Parameters: {}", parameters);

    assertThat(parameters).isInstanceOf(ArrayList.class);
  }
}