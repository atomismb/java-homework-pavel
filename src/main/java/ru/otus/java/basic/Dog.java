package ru.otus.java.basic;

public class Dog extends Animal {
    public Dog(String name, int velocityRun, int velocitySwim, int stamina) {
        super(name, velocityRun, velocitySwim, stamina);

    }

    @Override
    protected int getStaminaCost(int distance) {
        return distance * 2;

    }
}
