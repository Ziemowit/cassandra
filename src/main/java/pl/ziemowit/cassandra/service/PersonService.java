package pl.ziemowit.cassandra.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ziemowit.cassandra.model.PersonByBirthDate;
import pl.ziemowit.cassandra.model.PersonByCity;
import pl.ziemowit.cassandra.repo.PersonByBirthDateRepo;
import pl.ziemowit.cassandra.repo.PersonByCityRepo;
import pl.ziemowit.cassandra.repo.PersonCreateDTO;
import pl.ziemowit.cassandra.repo.PersonResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonByCityRepo personByCityRepo;
  private final PersonByBirthDateRepo personByBirthDateRepo;

  public Mono<PersonResponseDTO> create(PersonCreateDTO request) {
    var personByCity = personByCityRepo.save(request.toPersonByCity());
    var personByBirthDate = personByBirthDateRepo.save(request.toPersonByBirthDate());

    return personByBirthDate.then(personByCity)
                            .map(PersonResponseDTO::from);
  }

  public Flux<PersonByCity> findByCityAndEmail(String city, String email) {
    return Objects.isNull(email)
        ? personByCityRepo.findByKeyCity(city)
        : personByCityRepo.findByCityAndEmail(city, email);
  }

  public Flux<PersonByCity> findByCityAllowFiltering(String city, String firstName, String lastName) {
    return personByCityRepo.personByFilter(city, firstName, lastName);
  }

  public Flux<PersonByBirthDate> findByBirthDate(LocalDate birthDate) {
    return personByBirthDateRepo.findByKeyBirthDate(birthDate);
  }

}
