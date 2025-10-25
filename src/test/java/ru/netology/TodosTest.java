package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksInDifferentTypes() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить Хлеб");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Обсуждение Хлеба", "Проект Хлебозавод", "10:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOnlyMeetingTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить Молоко");
        Epic epic = new Epic(2, new String[]{"Яйца", "Сок"});
        Meeting meeting = new Meeting(3, "Совещание по проекту", "Важный проект", "12:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("проект");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOnlyEpicTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить маме");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Совещание", "Обсуждение", "14:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOnlySimpleTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить Молоко");
        Epic epic = new Epic(2, new String[]{"Яйца", "Сок"});
        Meeting meeting = new Meeting(3, "Совещание", "Обсуждение", "14:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Молоко");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoMatches() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить Молоко");
        Epic epic = new Epic(2, new String[]{"Яйца", "Сок"});
        Meeting meeting = new Meeting(3, "Совещание", "Обсуждение", "14:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayForEmptyQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить Молоко");
        Epic epic = new Epic(2, new String[]{"Яйца", "Сок"});

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected, actual);
    }
}
