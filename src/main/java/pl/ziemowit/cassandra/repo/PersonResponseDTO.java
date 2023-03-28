package pl.ziemowit.cassandra.repo;

import pl.ziemowit.cassandra.model.Person;

import java.time.LocalDate;

public record PersonResponseDTO(String email,
                                String city,
                                String firstName,
                                String lastName,
                                LocalDate birthDate) {

  public static PersonResponseDTO from(Person person) {
    return new PersonResponseDTO(person.getEmail(),
                                 person.getCity(),
                                 person.getFirstName(),
                                 person.getLastName(),
                                 person.getBirthDate());
  }

}
