package ru.otus.java.basic;

public abstract class Animal {
    String name;
    int velocityRun;
    int velocitySwim;
    int stamina;
    boolean isTired;

    public Animal(String name, int velocityRun, int velocitySwim, int stamina) {
        this.name = name;
        this.velocityRun = velocityRun;
        this.velocitySwim = velocitySwim;
        this.stamina = stamina;
    }

    public float run(int distance) {
        float timeRun;
        if (stamina < distance) {
            System.out.println("У " + name + " появилось состояние усталости");
            isTired = true;
            return -1;
        }
        timeRun = (float) distance / velocityRun;
        stamina -= distance;
        if (stamina < 0) {
            System.out.println("У " + name + " появилось состояние усталости");
            isTired = true;
        } else {
            System.out.println(name + " пробежал " + distance + " метров за " + timeRun + " секунд!");

        }
        return timeRun;
    }

    public abstract float swim(int distance);
    public void info(){
        if (isTired){
            System.out.println(name + " устал");
        }
        else {
            System.out.println("У " + name + " осталось " + stamina + " выносливости");
        }
    }


}
