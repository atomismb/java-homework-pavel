package ru.otus.java.basic;

    public class HomeWorkPanichenko {
        public static void main(String[] args) {
            Box<Apple> appleBox = new Box<>();
            Box<Orange> orangeBox = new Box<>();
            Box<Fruit> fruitBox = new Box<>();

            appleBox.addFruit(new Apple());
            appleBox.addFruit(new Apple());
            appleBox.addFruit(new Apple());

            orangeBox.addFruit(new Orange());
            orangeBox.addFruit(new Orange());

            fruitBox.addFruit(new Apple());
            fruitBox.addFruit(new Orange());
            fruitBox.addFruit(new Apple());

            System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
            System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
            System.out.println("Вес коробки с фруктами: " + fruitBox.getWeight());

            System.out.println("Коробка с яблоками и коробка с апельсинами равны по весу: " + appleBox.compare(orangeBox));

            Box<Apple> anotherAppleBox = new Box<>();
            System.out.println("Исходный вес новой коробки: " + anotherAppleBox.getWeight());
            anotherAppleBox.addFruit(new Apple());
            System.out.println("Вес новой коробки с яблоками: " + anotherAppleBox.getWeight());
            System.out.println("Исходная коробка с яблоками до пересыпания содержит: " + appleBox.getFruitCount() + " фруктов");
            appleBox.transferFruitsTo(anotherAppleBox);

            System.out.println("После пересыпания:");
            System.out.println("Исходная коробка с яблоками содержит: " + appleBox.getFruitCount() + " фруктов");
            System.out.println("Новая коробка с яблоками содержит: " + anotherAppleBox.getFruitCount() + " фруктов");
        }
    }
