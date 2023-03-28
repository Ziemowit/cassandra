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

  public static String F_CITY = "key.city";
  public static String F_EMAIL = "key.email";
  public static String F_FIRST_NAME = "firstName";
  public static String F_LAST_NAME = "lastName";

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
