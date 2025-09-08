package ru.otus.java.basic;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        User[] users = {
                new User("Василий", "Пуговкин", "Дмитриевич", 1980, "rere@be.re"),
                new User("Григорий", "Коробков", "Алибабаевич", 1981, "mary@kuy.ky"),
                new User("Анатолий", "Сиверин", "Борисович", 1982, "gorld@kuy.fe"),
                new User("Александр", "Роготовкин", "Савелиевич", 1983, "furiosa@kuy.se"),
                new User("Павел", "Кориндель", "Олегович", 1984, "robber@kuy.rt"),
                new User("Савва", "Леворуков", "Андреевич", 1985, "maori@kuy.cu"),
                new User("Корнелий", "Смерцепятов", "Анатолиевич", 1986, "fenrir@kuy.ru"),
                new User("Иван", "Крышеловцев", "Григорьевич", 1987, "neomonach@kuy.com"),
                new User("Андрей", "Кливлендов", "Вадимович", 1988, "kurt@kuy.fi"),
                new User("Руслан", "Бровадов", "Корнелиевич", 1989, "bromgexin@kuy.de")
        };

        for (int i = 0; i < users.length; i++) {
            int birthYear = users[i].getBirthYear();
            if ((2025 - birthYear) > 40) {
                users[i].info();
                System.out.println();
            }
        }
    }


}
