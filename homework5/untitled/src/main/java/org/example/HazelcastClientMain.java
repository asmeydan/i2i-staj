package org.example;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastClientMain {
    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();

        IMap<Integer, Person> map = client.getMap("personMap");

        for (int i = 1; i <= 10000; i++) {
            map.put(i, new Person("Person_" + i));
        }

        System.out.println("10.000 person nesnesi eklendi.");

        for (int i = 1; i <= 10; i++) {
            System.out.println("ID " + i + ": " + map.get(i));
        }

        client.shutdown();
    }
}