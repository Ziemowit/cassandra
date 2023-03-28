package pl.ziemowit.cassandra.model;


import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.LocalDate;

@PrimaryKeyClass
public record PersonByBirthDateKey(@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) LocalDate birthDate,
                                   @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED) String email) {
}
