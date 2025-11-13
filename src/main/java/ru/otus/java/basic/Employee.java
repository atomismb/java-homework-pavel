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

    public ArrayList<String> youngEmployee(ArrayList<Employee> list, int minAge) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.age >= minAge) {
                names.add(employee.name);
            }
        }
        return names;
    }




}
