package com.github.billy.keyvalue;

import com.github.billy.keyvalue.repository.Parameter;
import com.github.billy.keyvalue.repository.ParameterRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class KeyValueApplication {

  public static void main(String[] args) {
    SpringApplication.run(KeyValueApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(ParameterRepository repository) {
    return args -> {
      Parameter parameter = new Parameter();
      Set<String> values = new HashSet<>();
      values.add("gguzman@emeal.nttdata.com");
      values.add("oca2020@protonmail.com");
      values.add("oca2020@protonmail.com");
      parameter.setKey("addresses");
      parameter.setValues(values);
      repository.save(parameter);

      List<Parameter> parameterFound = new ArrayList<>();
      parameterFound = repository.findAll();
      for (Parameter p : parameterFound) {
        log.info("Parameter: {}", p);
/*        for (String s : p.getValues()) {
          log.info("Value: {}", s);
        }*/
      }
    };
  }
}
