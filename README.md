# learning-kafka


## Kafka Streams
The first step in any Kafka Streams program is to establish a source for the stream. The source could be any of the following:

* A single topic
* Multiple topics in a comma-separated list
* A regex that can match one or more topics



Kafka Streams is a graph of processing nodes that combine to provide powerful and complex stream processing.


Messages organized in topics


## Kafka 

Kafka runs in clusters

each broker has many partitions (copies in different servers)

consumerGroup 


```
/bin/kafka-topics.sh --zookeeper localhost:2181 --create --topic first --partitions 2 --replication-factor 1

./bin/kafka-topics.sh --zookeper localhost:2181 --describe --topic first


./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic first

./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first

//after type messages in producer terminal
```
