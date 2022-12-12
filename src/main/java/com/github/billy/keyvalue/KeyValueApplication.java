package com.github.billy.keyvalue;

import com.github.billy.keyvalue.repository.Parameters;
import com.github.billy.keyvalue.repository.ParametersRepository;
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
  CommandLineRunner runner(ParametersRepository repository) {
    return args -> {
      Parameters parameters = new Parameters();
      Set<String> values = new HashSet<>();
      values.add("gguzman@emeal.nttdata.com");
      values.add("oca2020@protonmail.com");
      values.add("oca2020@protonmail.com");
      parameters.setKey("addresses");
      parameters.setValues(values);
      repository.save(parameters);

      List<Parameters> parametersFound = new ArrayList<>();
      parametersFound = repository.findAll();
      for (Parameters p : parametersFound) {
        log.info("Parameter: {}", p);
/*        for (String s : p.getValues()) {
          log.info("Value: {}", s);
        }*/
      }
    };
  }
}
