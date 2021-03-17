# event-sourcing-kafka-tests
tests with kafka 

Project create for simple tests with producer and consumer kafka


## setup
Download and start kafka

https://kafka.apache.org/downloads

Start kafka 
bin/kafka-server-start.sh config/server.properties

Start zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

Cria topico
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 partitions 1 --topic name


## running

rodar a classe main de consumer - KafkaReceiver
rodar a classe main de producer - KafkaSender
