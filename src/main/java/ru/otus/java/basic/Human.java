package ru.otus.java.basic;

public class Human {
    private String name;
    private Transport currentTransport;


    public Human(String name) {
        this.name = name;
        this.currentTransport = null;

    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }


    public String getName() {
        return name;
    }

    public void mount(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " не может сейчас сесть на " + transport.getName()+
                    ", так как сидит на " + currentTransport.getName());
            return;
        }
        this.currentTransport = transport;
        System.out.println(name + " сел на " + transport.getName());

    }

    public void dismount() {
        if (currentTransport != null) {
            System.out.println(name + " слез с " + currentTransport.getName());
            currentTransport = null;
        } else {
            System.out.println(name + " не находится на транспорте");
        }
    }

    public boolean move(int distance, TerrainType terrain) {
        if (currentTransport != null) {
            System.out.println(name + " пытается переместиться на " + distance + " метров по " + terrain.getDescription() + " на " + currentTransport.getName());
            boolean success = currentTransport.move(distance, terrain);
            if (success) {
                System.out.println(name + " успешно переместился на " + distance + " метров");
            } else {
                System.out.println(name + " не смог переместиться на " + distance + " метров");
            }
            return success;
        } else {
            System.out.println(name + " прошел " + distance + " метров пешком по " + terrain.getDescription());
            return true;
        }

    }
}
