package com.github.billy.keyvalue.mapper;

import com.github.billy.keyvalue.domain.Parameter;
import com.github.billy.keyvalue.repository.ParameterJpaEntity;
import com.github.billy.keyvalue.type.Key;
import com.github.billy.keyvalue.type.KeyMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    uses = {KeyMapper.class})
public interface ParameterMapper {

  ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);

  default List<Parameter> toDomain(List<ParameterJpaEntity> entities) {
    return Objects.isNull(entities) ? Collections.emptyList()
        : entities.stream().map(this::toDomain).collect(Collectors.toList());
  }

  default Parameter toDomain(ParameterJpaEntity entity) {
    return Objects.isNull(entity) ? null
        : new Parameter(Key.of(entity.getKey()), entity.getValues());
  }

  default List<ParameterJpaEntity> toJpaEntity(Parameter parameter) {
    if (Objects.isNull(parameter)) {
      return Collections.emptyList();
    }
    List<ParameterJpaEntity> entities = new ArrayList<>();
    for (Map.Entry<Key, Set<String>> entry : parameter.entrySet()) {
      entities.add(
          new ParameterJpaEntity(0L, entry.getKey().getValue(), entry.getValue()));
    }
    return entities;
  }
}
