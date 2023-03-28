package pl.ziemowit.cassandra.model;


import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public record PersonByCityKey(@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) String city,
                              @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED) String email) {
}
