package org.example;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class App {
    public static void main( String[] args ) {
        Random random = new Random();
        Set<Flower> flowerbed = new HashSet<>();
        for (int i = 0; i < 10; ++i) {
            Flower f = new Flower("Цветок-" + i, random.nextBoolean());
            flowerbed.add(f);
            System.out.println(f.getName() + " - " + (f.isWithered() ? "Завял" : "Жив"));
        }
        Worker worker1 = new Worker("Павел", flowerbed);
        Worker worker2 = new Worker("Иван", flowerbed);
        System.out.println("----- Начало полива -----");
        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);
        thread1.start();
        thread2.start();
    }
}
