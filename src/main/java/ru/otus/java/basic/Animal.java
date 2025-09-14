package ru.otus.java.basic;

public abstract class Animal {
    protected String name;
    protected int velocityRun;
    protected int velocitySwim;
    protected int stamina;
    protected boolean isTired;

    public Animal(String name, int velocityRun, int velocitySwim, int stamina) {
        this.name = name;
        this.velocityRun = velocityRun;
        this.velocitySwim = velocitySwim;
        this.stamina = stamina;
    }

    protected float run(int distance) {
        float timeRun;
        if (stamina < distance || stamina <= 0 || isTired) {
            System.out.println("У " + name + " появилось состояние усталости");
            isTired = true;
            return -1;
        } else {
            timeRun = (float) distance / velocityRun;
            stamina -= distance;
            System.out.println(name + " пробежал " + distance + " метров за " + timeRun + " секунд!");
        }
        return timeRun;
    }

    protected abstract float swim(int distance);

    protected void info() {
        if (isTired) {
            System.out.println(name + " устал");
        } else {
            System.out.println("У " + name + " осталось " + stamina + " выносливости");
        }
    }
}
