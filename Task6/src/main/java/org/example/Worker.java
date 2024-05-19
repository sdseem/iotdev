package org.example;

import java.util.Set;

public class Worker implements Runnable {

    private final String name;

    private final Set<Flower> flowerbed;

    public Worker(String name, Set<Flower> flowerbed) {
        this.flowerbed = flowerbed;
        this.name = "Работник " + name + " выполняет полив: ";
    }

    @Override
    public void run() {
        for (Flower flower : flowerbed) {
            String res;
            try {
                res = flower.watering();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + res);
        }
    }
}
