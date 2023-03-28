package pl.ziemowit.cassandra.repo;

import pl.ziemowit.cassandra.model.PersonByCity;

import java.time.LocalDate;

public record PersonResponseDTO(String email,
                                String city,
                                String firstName,
                                String lastName,
                                LocalDate birthDate) {

  public static PersonResponseDTO from(PersonByCity person) {
    return new PersonResponseDTO(person.getKey().email(),
                                 person.getKey().city(),
                                 person.getFirstName(),
                                 person.getLastName(),
                                 person.getBirthDate());
  }

}
