package ru.otus.java.basic;

public class Dog extends Animal {
    public Dog(String name, int velocityRun, int velocitySwim, int stamina) {
        super(name, velocityRun, velocitySwim, stamina);

    }

    @Override
    public float swim(int distance) {
        if (stamina < distance) {
            System.out.println("У " + name + " появилось состояние усталости");
            isTired = true;
            return -1;
        }
        float timeSwim;
        timeSwim = (float) distance / velocitySwim;
        stamina -= distance * 2;
        if (stamina < 0) {
            System.out.println("У " + name + " появилось состояние усталости");
            isTired = true;
        } else {
            System.out.println(name + " проплыл " + distance + " метров за " + timeSwim + " секунд!");

        }
        return timeSwim;

    }
}
