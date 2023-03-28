package pl.ziemowit.cassandra.repo;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import pl.ziemowit.cassandra.model.PersonByBirthDate;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface PersonByBirthDateRepo extends ReactiveCassandraRepository<PersonByBirthDate, PersonByBirthDate> {

  Flux<PersonByBirthDate> findByKeyBirthDate(LocalDate birthDate);

}
