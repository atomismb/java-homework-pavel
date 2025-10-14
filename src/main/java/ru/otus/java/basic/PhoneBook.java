package ru.otus.java.basic;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> contacts = new HashMap<>();

    public void add(String fio, String phoneNumber) {

        if (!contacts.containsKey(fio)) {
            contacts.put(fio, new ArrayList<>());
        }
        contacts.get(fio).add(phoneNumber);
    }

    public List<String> find(String surname) {
        List<String> result = new ArrayList<>();
        for (String fio : contacts.keySet()) {
            String[] nameParts = fio.split(" ");
            String currentSurname = nameParts[0];
            if (currentSurname.equals(surname)) {
                result.addAll(contacts.get(fio));
            }
        }
        return result;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (List<String> phones : contacts.values()) {
            if (phones.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}


