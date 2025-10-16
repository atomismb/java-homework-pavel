package ru.otus.java.basic;

import java.util.HashMap;
import java.util.HashSet;

public class PersonDataBase {
    private HashMap<Long, Person> personsById;
    private HashSet<Long> employeeIds;

    public PersonDataBase() {
        personsById = new HashMap<>();
        employeeIds = new HashSet<>();
    }

    public Person findById(Long id) {
        return personsById.get(id);
    }

    public void add(Person person) {
        if (person == null || person.getId() == null) {
            throw new IllegalArgumentException("Сотрудник или его Id не может быть \"null\"!");
        }
        personsById.put(person.getId(), person);
        if (!isManager(person)) {
            employeeIds.add(person.getId());
        }
    }


    public boolean isManager(Person person) {
        if (person == null || person.getPosition() == null) {
            return false;
        }

        Position position = person.getPosition();
        return position == Position.MANAGER ||
                position == Position.DIRECTOR ||
                position == Position.BRANCH_DIRECTOR ||
                position == Position.SENIOR_MANAGER;
    }

    public boolean isEmployee(Long id) {
        return employeeIds.contains(id);
    }
}

