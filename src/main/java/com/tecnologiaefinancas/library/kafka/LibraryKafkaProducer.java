package com.tecnologiaefinancas.library.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class LibraryKafkaProducer {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        producer.send(new ProducerRecord<>("library-topic", "978-3-16-148410-0", "The Great Gatsby"));
        producer.send(new ProducerRecord<>("library-topic", "978-0-14-032872-1", "Charlotte's Web"));
        producer.send(new ProducerRecord<>("library-topic", "978-0-7432-7356-5", "To Kill a Mockingbird"));

        producer.close();
    }
}

