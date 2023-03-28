package pl.ziemowit.cassandra.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import pl.ziemowit.cassandra.model.PersonByCity;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class PersonByCityRepoCustomImpl implements PersonByCityRepoCustom {

  private final ReactiveCassandraTemplate cassandra;

  @Override
  public Flux<PersonByCity> findByCityAndEmail(String city, String email) {
    var query = Query.query(Criteria.where(PersonByCity.F_CITY).is(city),
                            Criteria.where(PersonByCity.F_EMAIL).is(email));

    return cassandra.select(query, PersonByCity.class);
  }

  @Override
  public Flux<PersonByCity> personByFilter(String city, String firstName, String lastName) {
    var query = Query.query(Criteria.where(PersonByCity.F_CITY).is(city),
                            Criteria.where(PersonByCity.F_FIRST_NAME).is(firstName),
                            Criteria.where(PersonByCity.F_LAST_NAME).is(lastName))
                     .withAllowFiltering();

    return cassandra.select(query, PersonByCity.class);
  }

}
