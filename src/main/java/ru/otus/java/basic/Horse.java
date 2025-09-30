package ru.otus.java.basic;

class Horse implements Transport {
    private int stamina;
    private final int maxStamina;
    private final int staminaConsumption; // расход на 1 км

    Horse(int maxStamina, int staminaConsumption) {
        this.maxStamina = maxStamina;
        this.stamina = maxStamina;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Лошадь не может идти по " + terrain.getDescription());
            return false;
        }

        int requiredStamina = distance * staminaConsumption;
        if (requiredStamina > stamina) {
            System.out.println("Лошадь слишком устала! Нужно выносливости: " + requiredStamina + ", есть: " + stamina);
            return false;
        }

        stamina -= requiredStamina;
        System.out.println("Лошадь прошла " + distance + " метров по " + terrain.getDescription() +
                ". Потрачено выносливости: " + requiredStamina + ". Осталось выносливости: " + stamina);
        return true;
    }

    @Override
    public String getName() {
        return "лошадь";
    }

    public void rest() {
        stamina = maxStamina;
        System.out.println("Лошадь отдохнула. Силы восстановлены, ее выносливость: " + stamina);
    }

    public int getStamina() {
        return stamina;
    }
}
