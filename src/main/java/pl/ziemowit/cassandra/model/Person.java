package pl.ziemowit.cassandra.model;

import java.time.LocalDate;

public interface Person {

  String getEmail();

  String getCity();

  String getFirstName();

  String getLastName();

  LocalDate getBirthDate();

}
