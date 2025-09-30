package ru.otus.java.basic;

class Vezdehod implements Transport {
    private int fuel;
    private int fuelCapacity;
    private int fuelConsumption;

    Vezdehod(int fuelCapacity, int fuelConsumption) {
        this.fuelCapacity = fuelCapacity;
        this.fuel = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        int requiredFuel = distance * fuelConsumption;
        if (requiredFuel > fuel) {
            System.out.println("Недостаточно топлива! Нужно: " + requiredFuel + " л, есть: " + fuel + " л");
            return false;
        }

        fuel -= requiredFuel;
        System.out.println("Вездеход проехал " + distance + " метров по " + terrain.getDescription() + ". Израсходовано: " + requiredFuel + " л. Осталось топлива: " + fuel + " л");
        return true;
    }

    @Override
    public String getName() {
        return "вездеход";
    }

    public void refuel(int amount) {
        fuel = Math.min(fuel + amount, fuelCapacity);
        System.out.println("Вездеход заправлен. Топлива: " + fuel + " л");
    }

    public int getFuel() {
        return fuel;
    }
}
