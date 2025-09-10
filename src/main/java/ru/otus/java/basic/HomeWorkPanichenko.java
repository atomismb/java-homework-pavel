package ru.otus.java.basic;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
      Cat cat = new Cat("Барсик", 10,1,5);
        Dog dog1 = new Dog("Артемон", 8,4,200);
        Horse horse = new Horse("Игогошенька", 2,1,100);

      cat.run(1);
      cat.swim(10);
      dog1.run(5);
      dog1.swim(5);
      dog1.swim(5);
      cat.info();
        cat.run(5);
        cat.info();
        horse.swim(100);
        horse.info();


    }
}
