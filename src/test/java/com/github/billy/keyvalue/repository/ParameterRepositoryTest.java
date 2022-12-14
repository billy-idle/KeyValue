package com.github.billy.keyvalue.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.billy.keyvalue.domain.Parameter;
import com.github.billy.keyvalue.domain.ParameterTest;
import com.github.billy.keyvalue.mapper.ParameterMapper;
import com.github.billy.keyvalue.type.Key;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ParameterRepositoryTest {

  @Autowired
  private ParameterRepository repository;
  @Autowired
  private ParameterMapper parameterMapper;

  @Test
  void canSaveParameterEntity() {
    assertThat(repository.save(ParameterJpaEntityTest.buildInstance())).isInstanceOf(
        ParameterJpaEntity.class);
  }

  @Test
  void canSaveListOfParameterEntities() {
    List<ParameterJpaEntity> entities = new ArrayList<>();

    entities.add(ParameterJpaEntityTest.buildInstance());
    entities.add(ParameterJpaEntityTest.buildInstance());
    entities.add(ParameterJpaEntityTest.buildInstance());

    assertThat(repository.saveAll(entities)).isInstanceOf(List.class);
  }

  @Test
  void canSaveParameter() {
    Parameter parameter = ParameterTest.buildInstance();
    log.info("Parameter: {}", parameter);
    List<ParameterJpaEntity> entity = parameterMapper.toJpaEntity(parameter);
    log.info("Entity: {}", entity);
    assertThat(repository.saveAll(entity)).isInstanceOf(List.class);
  }

  @Test
  void save_parameter_then_findByKey(){
    Parameter parameter = ParameterTest.buildInstance();
    Key key = ParameterTest.key;
//    Key key = Key.of("dontYou");
    log.info("Parameter: {}", parameter);
    repository.saveAll(parameterMapper.toJpaEntity(parameter));
    assertThat(parameterMapper.toDomain(repository.findByKey(key.getValue()))).isEqualTo(parameter);
  }
}