package ru.otus.java.basic;

public class User {
    private String name;
    private String surname;
    private String otchestvo;
    private int birthYear;
    private String email;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getEmail() {
        return email;
    }
    public User(String name, String surname, String otchestvo, int birthYear, String email){
    this.name = name;
    this.surname = surname;
    this.otchestvo = otchestvo;
    this.birthYear = birthYear;
    this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + surname + " " + name + " " + otchestvo);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("email: " + email);
    }
}


