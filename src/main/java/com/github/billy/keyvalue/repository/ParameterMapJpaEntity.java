package com.github.billy.keyvalue.repository;

import java.util.Map;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "PARAMETER_MAP")
public class ParameterMapJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "keey", nullable = false, unique = true)
  private String key; //no se pudo usar "key" en H2 - http://www.h2database.com/html/advanced.html#keywords
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "VALUES_PARAMETER_MAP", joinColumns = @JoinColumn(name = "id"))
  @Column(name = "vaalues", unique = true)
  private Map<String, String> values;
}
