package pl.ziemowit.cassandra.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Table("person_by_city")
public class PersonByCity implements Person {

  @PrimaryKey
  private final PersonByCityKey key;

  private String firstName;
  private String lastName;
  private LocalDate birthDate;

  @Override
  public String getEmail() {
    return key.email();
  }

  @Override
  public String getCity() {
    return key.city();
  }
}
