package org.example;

public class Flower {
    private String name;
    private boolean isWithered;

    public Flower(String name, boolean isWithered) {
        this.name = name;
        this.isWithered = isWithered;
    }

    public synchronized String watering() throws InterruptedException {
        if (!isWithered) {
            return "Цветок " + name + " уже был полит. Повторно не поливается.";
        }
        Thread.sleep(500);
        isWithered = false;
        return "Цветок " + name + " полит.";
    }

    public String getName() {
        return this.name;
    }

    public boolean isWithered() {
        return this.isWithered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (isWithered != flower.isWithered) return false;
        return name != null ? name.equals(flower.name) : flower.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (isWithered ? 1 : 0);
        return result;
    }
}
