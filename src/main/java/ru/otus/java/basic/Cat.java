package ru.otus.java.basic;

public class Cat extends Animal {

    public Cat(String name, int velocityRun, int velocitySwim, int stamina) {
        super(name, velocityRun, velocitySwim, stamina);

    }
    protected int getStaminaCost(int distance) {
        return -1;
    }
    @Override
    public float swim(int distance) {
        System.out.println("Кот " + name + " не умеет плавать");
        return -1;
    }
}
