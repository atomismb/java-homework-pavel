package ru.otus.java.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PersonDataBase {
    private HashMap<Long, Person> personsById;
    private HashSet<Long> employeeIds;
    private Set<Position> manager = new HashSet<>(Set.of(
            Position.MANAGER,
            Position.DIRECTOR,
            Position.BRANCH_DIRECTOR,
            Position.SENIOR_MANAGER
    ));

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

            return manager.contains(person.getPosition());
    }

    public boolean isEmployee(Long id) {
        return employeeIds.contains(id);
    }
}

