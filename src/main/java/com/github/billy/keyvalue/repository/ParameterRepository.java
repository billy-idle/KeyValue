package com.github.billy.keyvalue.repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<ParameterJpaEntity, Long> {

  ParameterJpaEntity findByKey(String key);
}
