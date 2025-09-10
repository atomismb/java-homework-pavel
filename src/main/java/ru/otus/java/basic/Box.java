package ru.otus.java.basic;

public class Box {
    private int length;
    private int width;
    private int height;
    private String color;
    private boolean boxState;
    private boolean smthInTheBox;
    private String predmet;

    public void setColor(String color) {
        if (!boxState) {
            System.out.println("Нельзя перекрасить закрытую коробку!");
            return;
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public Box(int length, int width, int height, String color, String predmet) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.predmet = predmet;
    }

    public void openCloseBox() {
        if (!boxState) {
            System.out.println("Вы открываете коробку. Коробка открыта!");
        } else {
            System.out.println("Вы закрываете коробку. Коробка закрыта!");
        }
        boxState = !boxState;
    }

    public void info() {
        System.out.println("Размеры коробки:");
        System.out.println("Длина: " + length + "см");
        System.out.println("Ширина: " + width + "см");
        System.out.println("Высота: " + height + "см");
        System.out.println("Цвет: " + color);
    }

    public void putThing() {
        if (!boxState) {
            System.out.println("Коробка закрыта! Сперва откройте её.");
            return;
        }
        if (smthInTheBox) {
            System.out.println("В коробке лежит " + predmet + ", вы не можете положить в коробку ничего");
        } else {
            System.out.println("Вы кладёте " + predmet + " в коробку");
            smthInTheBox = true;
        }
    }

    public void getThing() {
        if (!boxState) {
            System.out.println("Коробка закрыта! Сперва откройте её.");
            return;
        }
        if (smthInTheBox) {
            System.out.println("Вы достаёте " + predmet + " из коробки");
            smthInTheBox = false;
        } else {
            System.out.println("В коробке ничего нет, она пуста");
        }
    }
}