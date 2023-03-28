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
@Table("person_by_birth_date")
public class PersonByBirthDate implements Person {

  @PrimaryKey
  private final PersonByBirthDateKey key;

  private String firstName;
  private String lastName;
  private String city;

  @Override
  public String getEmail() {
    return key.email();
  }

  @Override
  public LocalDate getBirthDate() {
    return key.birthDate();
  }
}
