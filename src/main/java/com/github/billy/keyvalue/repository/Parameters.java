package com.github.billy.keyvalue.repository;

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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Setter
@Getter
@Table
public class Parameters {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "k", nullable = false, unique = true)
  private String key; //no se pudo usar "key" en H2 - http://www.h2database.com/html/advanced.html#keywords
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "value_list", joinColumns = @JoinColumn(name = "id"))
  @Column(name = "v", unique = true)
  private Set<String> values;
}
