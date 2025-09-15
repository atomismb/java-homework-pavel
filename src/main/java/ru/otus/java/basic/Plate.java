package ru.otus.java.basic;

public class Plate {
    private int foodMax;
    private int foodCurrent;

    public Plate() {
        foodMax = 100;
        foodCurrent = foodMax;
        System.out.println("В тарелке лежит " + foodMax + " еды. Тарелка больше не вмещает");
    }

    public int getFoodCurrent() {
        return foodCurrent;
    }

    public Plate(int foodMax, int foodCurrent, int volume) {
        this.foodMax = foodMax;
        this.foodCurrent = foodCurrent;
    }

    protected boolean decreaseFood(int amount) {
        if (foodCurrent <= 0) {
            return false;
        } else {
            foodCurrent -= amount;
            return true;
        }
    }

    protected void increaseFood(int amount) {
        if (foodCurrent + amount > foodMax) {
            foodCurrent = foodMax;
            System.out.println("Вы заполнили тарелку доверху. Лишняя еда высыпалась из тарелки");
        } else {
            foodCurrent += amount;
            System.out.println("Вы положили в тарелку " + amount + " еды");
        }
    }

    protected void infoPlate() {
        System.out.println("В тарелке сейчас " + foodCurrent + " еды");
    }
}
