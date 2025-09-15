package ru.otus.java.basic;

public class HomeWorkPanichenko {
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 99),
                new Cat("Murzik", 50),
                new Cat("Din", 3)
        };
        Plate plate = new Plate();
        for (int i = 0; i < cats.length; i++) {
            cats[i].feedCat(plate);
        }
        cats[0].feedCat(plate);
        plate.infoPlate();
        plate.increaseFood(15);
        plate.infoPlate();
        plate.increaseFood(100);
        plate.infoPlate();
    }
}
