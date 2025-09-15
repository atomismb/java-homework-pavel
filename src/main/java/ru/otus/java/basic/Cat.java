package ru.otus.java.basic;

public class Cat {
    private String name;
    private int appetite;
    private boolean isHungry = true;

    public boolean getIsHungry() {
        return isHungry;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", isHungry=" + isHungry +
                '}';
    }

    protected void feedCat(Plate plate) {
        if (!isHungry) {
            System.out.println(name + " сыт и не хочет кушать");

        } else if (appetite > plate.getFoodCurrent()) {
            System.out.println(name + " не хватает еды в тарелке и он, не поев, недовольный уходит спать. \nСостояние сытости " + name + ": " + !isHungry);

        } else {
            plate.decreaseFood(appetite);
            isHungry = false;
            System.out.println(name + " - поел, его состояние сытости: " + !isHungry);
        }
    }
}
