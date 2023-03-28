package pl.ziemowit.cassandra.repo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.ziemowit.cassandra.model.PersonByBirthDate;
import pl.ziemowit.cassandra.model.PersonByBirthDateKey;
import pl.ziemowit.cassandra.model.PersonByCity;
import pl.ziemowit.cassandra.model.PersonByCityKey;

import java.time.LocalDate;

public record PersonCreateDTO(@Email String email,
                              @NotBlank String city,
                              @NotBlank String firstName,
                              @NotBlank String lastName,
                              @NotNull LocalDate birthDate) {

  @JsonIgnore
  public PersonByCity toPersonByCity() {
    return new PersonByCity(new PersonByCityKey(city(),
                                                email()),
                            firstName(),
                            lastName(),
                            birthDate());
  }

  @JsonIgnore
  public PersonByBirthDate toPersonByBirthDate() {
    return new PersonByBirthDate(new PersonByBirthDateKey(birthDate(),
                                                          email()),
                                 firstName(),
                                 lastName(),
                                 city());
  }

}
