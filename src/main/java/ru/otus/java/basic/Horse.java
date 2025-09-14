package ru.otus.java.basic;

public class Horse extends Animal {
    public Horse(String name, int velocityRun, int velocitySwim, int stamina) {
        super(name, velocityRun, velocitySwim, stamina);
    }

    @Override
    protected float swim(int distance) {
        float timeSwim;
        if (stamina < distance * 4 || stamina <= 0 || isTired) {
            System.out.println("У " + name + " появилось состояние усталости");
            isTired = true;
            return -1;
        } else {
            timeSwim = (float) distance / velocitySwim;
            stamina -= distance * 4;
            System.out.println(name + " проплыл " + distance + " метров за " + timeSwim + " секунд!");
        }
        return timeSwim;
    }
}
