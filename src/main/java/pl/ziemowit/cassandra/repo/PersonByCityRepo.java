package pl.ziemowit.cassandra.repo;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import pl.ziemowit.cassandra.model.PersonByCity;
import pl.ziemowit.cassandra.model.PersonByCityKey;
import reactor.core.publisher.Flux;

public interface PersonByCityRepo extends ReactiveCassandraRepository<PersonByCity, PersonByCityKey> {

  Flux<PersonByCity> findByKeyCity(String city);

}
