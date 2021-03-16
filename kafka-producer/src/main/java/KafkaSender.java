import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

public class KafkaSender implements Closeable {

    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        var producer = new KafkaProducer<String, String>(kafkaProps);

        for(int i=0; i<15; i++) {
            ProducerRecord<String, String> record =
                    new ProducerRecord<>("TestTopic1",
                            "Chave_"+i,
                            "value_" + UUID.randomUUID().getMostSignificantBits());
            try {
                producer.send(record).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    @Override
    public void close() throws IOException {

    }
}
