package ru.otus.java.basic;

import java.util.ArrayList;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Сотрудник {имя='" + name + "', возраст=" + age + '}';
    }

    public static ArrayList<String> listOfNames(ArrayList<Employee> list) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee employee : list) {
            names.add(employee.name);
        }
        return names;
    }

    public static ArrayList<String> youngEmployee(ArrayList<Employee> list, int minAge) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.age >= minAge) {
                names.add(employee.name);
            }
        }
        return names;
    }

    public static void avarageAge(ArrayList<Employee> list, int avgAge) {
        int emloyeeAge = 0;
        for (Employee employee : list) {
            emloyeeAge += employee.age;
        }
        if (emloyeeAge / list.size() >= avgAge) {
            System.out.println("Средний возраст сотрудников больше " + avgAge);

        } else {
            System.out.println("Средний возраст сотрудников меньше " + avgAge);
        }

    }

    public static Employee youngestEmployee(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            return null;
        } else {
            Employee youngest = list.get(0);
            for (Employee employee : list) {
                if (employee.age < youngest.age) {
                    youngest = employee;
                }
            }
            return youngest;
        }
    }
}
