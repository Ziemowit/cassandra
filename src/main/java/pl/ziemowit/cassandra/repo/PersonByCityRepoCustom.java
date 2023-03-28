package pl.ziemowit.cassandra.repo;

import pl.ziemowit.cassandra.model.PersonByCity;
import reactor.core.publisher.Flux;

public interface PersonByCityRepoCustom {

  Flux<PersonByCity> findByCityAndEmail(String city, String email);

  Flux<PersonByCity> personByFilter(String city, String firstName, String lastName);

}
