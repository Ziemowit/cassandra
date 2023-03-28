# 1. ACID

a) Atomicity 

Transaction is treated as a single "unit", which either succeeds completely or fails completely

b) Consistency

Consistency ensures that a transaction can only bring the database from one consistent state to another.

c) Isolation

Ensures that concurrent execution of transactions leaves the database in the same state that would have been obtained if the transactions were executed sequentially.

d) Durability

Durability guarantees that once a transaction has been committed, it will remain committed even in the case of a system failure/crash.

# 2. CAP

![img.png](images/img.png)

Cassandra == AP

**a) Consistency**

Every read receives the most recent write or an error.

**b) Availability**

Every request receives a (non-error) response, without the guarantee that it contains the most recent write.

**c) Partition tolerance**

The system continues to operate despite an arbitrary number of messages being dropped (or delayed) by the network between nodes.

# 3. Cassandra

## 3.1 Keys

PRIMARY KEY = PARTITION KEY + CLUSTER KEY

PARTITION KEY => hashing_function(key) => check_hash_range(hash) => apply_to_node

## 3.2 Replication

* Done automatically
* Done asynchronously
* Replication Factor by default 3 
  * how many copiers are kept in the cluster
  * set per KEYSPACE (collection of Tables)
* In case node is down - replication is replayed later

## 3.3 Consistency Levels

* Per query (examples are ONE, QUORUM, ALL)

## 3.4 Consistency Repair

* By default, 10% od read query with consistency < ALL performs read repair in the background
* Setting is per Table
