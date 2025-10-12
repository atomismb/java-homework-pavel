package ru.otus.java.basic;

import java.util.ArrayList;

public class EmployeeTwo {
    public static ArrayList<String> listOfNames(ArrayList<Employee> list) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee employee : list) {
            names.add(employee.getName());
        }
        return names;
    }
    public static void avarageAge(ArrayList<Employee> list, int avgAge) {
        int emloyeeAge = 0;
        for (Employee employee : list) {
            emloyeeAge += employee.getAge();
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
                if (employee.getAge() < youngest.getAge()) {
                    youngest = employee;
                }
            }
            return youngest;
        }
    }

}
