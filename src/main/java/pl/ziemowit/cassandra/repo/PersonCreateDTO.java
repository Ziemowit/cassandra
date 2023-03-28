package pl.ziemowit.cassandra.repo;

import java.time.LocalDate;

public record PersonCreateDTO(String email,
                              String city,
                              String firstName,
                              String lastName,
                              LocalDate birthDate) {
}
