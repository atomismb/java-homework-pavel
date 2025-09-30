package ru.otus.java.basic;

class Bicycle implements Transport {
    private int riderStamina;
    private final int maxRiderStamina;
    private final int staminaConsumption;

    Bicycle(int maxRiderStamina, int staminaConsumption) {
        this.maxRiderStamina = maxRiderStamina;
        this.riderStamina = maxRiderStamina;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Велосипед не может ехать по " + terrain.getDescription());
            return false;
        }

        int requiredStamina = distance * staminaConsumption;
        if (requiredStamina > riderStamina) {
            System.out.println("Всадник слишком устал! Нужно выносливости: " + requiredStamina + ", есть: " + riderStamina);
            return false;
        }

        riderStamina -= requiredStamina;
        System.out.println("Человек на велосипеде проехал " + distance + " метров по " + terrain.getDescription() +
                ". Потрачено выносливости всадника: " + requiredStamina + ". Осталось выносливости: " + riderStamina);
        return true;
    }

    @Override
    public String getName() {
        return "велосипед";
    }

    public void rest() {
        riderStamina = maxRiderStamina;
        System.out.println("Всадник отдохнул. Силы восстановлены, его выносливость: " + riderStamina);
    }

    public int getRiderStamina() {
        return riderStamina;
    }
}
