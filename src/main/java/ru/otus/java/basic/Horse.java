package ru.otus.java.basic;

public class Horse extends Animal {
    public Horse(String name, int velocityRun, int velocitySwim, int stamina) {
        super(name, velocityRun, velocitySwim, stamina);
    }

    protected int getStaminaCost(int distance) {
        return distance * 4;
    }
}
