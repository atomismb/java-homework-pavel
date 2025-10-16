package ru.otus.java.basic;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        PersonDataBase database = new PersonDataBase();
        database.add(new Person("Иван Андреевич Пустовалов", Position.MANAGER, 1L));
        database.add(new Person("Петр Александрович Разработчиков", Position.DEVELOPER, 2L));
        database.add(new Person("Ильдар Наилевич Сайдашев", Position.DIRECTOR, 3L));
        database.add(new Person("Константин Сергеевич Бессонов", Position.QA, 4L));

        Person person = database.findById(2L);
        System.out.println("Найден сотрудник: " + person);

        Person manager = database.findById(1L);
        System.out.println("Является ли менеджером сотрудник с ID=" + manager.getId() + ": " + database.isManager(manager));

        System.out.println("Является ли рядовым сотрудником сотрудник с ID=" + person.getId() + ": " + database.isEmployee(3L));

        int[] array1 = {70, 100, 20, 90, 30, 10, 50};
        System.out.println("Исходный массив: " + java.util.Arrays.toString(array1));

        SortUtils.bubbleSort(array1);
        System.out.println("После bubbleSort: " + java.util.Arrays.toString(array1));

        int[] array2 = {70, 100, 20, 90, 30, 10, 50};
        SortUtils.quickSort(array2);
        System.out.println("После quickSort: " + java.util.Arrays.toString(array2));
    }
}