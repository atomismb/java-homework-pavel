package ru.otus.java.basic;

class Car implements Transport {
    private int fuel;
    private int fuelCapacity;
    private int fuelConsumption;

    Car(int fuelCapacity, int fuelConsumption) {
        this.fuelCapacity = fuelCapacity;
        this.fuel = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.DENSE_FOREST || terrain == TerrainType.SWAMP) {
            System.out.println("Машина не может ехать по " + terrain.getDescription());
            return false;
        }


        int requiredFuel = distance * fuelConsumption;
        if (requiredFuel > fuel) {
            System.out.println("Недостаточно топлива! Нужно: " + requiredFuel + " л, есть: " + fuel + " л");
            return false;
        }


        fuel -= requiredFuel;
        System.out.println("Машина проехала " + distance + " метров по " + terrain.getDescription() +
                ". Израсходовано: " + requiredFuel + " л. Осталось топлива: " + fuel + " л");
        return true;
    }

    @Override
    public String getName() {
        return "машина";
    }

    public void refuel(int amount) {
        fuel = Math.min(fuel + amount, fuelCapacity);
        System.out.println("Машина заправлена. Топлива: " + fuel + " л");
    }

    public int getFuel() {
        return fuel;
    }
}
