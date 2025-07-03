package org.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.google.gson.Gson;

public class BasicProducer {

    public static final String TOPIC = "hello-world-topic";

    public static void main(String[] args) {

        System.out.println("*** Starting Basic Producer ***");

        Properties settings = new Properties();

        settings.put("client.id", "basic-producer");
        settings.put("bootstrap.servers", "localhost:9093");
        settings.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        settings.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(settings)) {
            Gson gson = new Gson(); // JSON için Gson objesi

            for (int i = 1; i <= 5; i++) {
                Student student = new Student(i, "Student-" + i); // Nesne oluştur
                String json = gson.toJson(student); // JSON'a çevir

                System.out.println("Gönderiliyor: " + json);

                // Kafka'ya gönder
                producer.send(new ProducerRecord<>(TOPIC, "student-" + i, json));
            }
        }
    }
}