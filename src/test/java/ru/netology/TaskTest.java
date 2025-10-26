package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchSimpleTaskCaseSensitive() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchEpicWhenQueryNoFound() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchMeetingInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchMeetingInProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchMeetingWhenQueryNotFound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("понедельник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        int expectedId = 5;
        String expectedTitle = "Позвонить родителям";

        Assertions.assertEquals(expectedId, simpleTask.getId());
        Assertions.assertEquals(expectedTitle, simpleTask.getTitle());
    }

    @Test
    public void shouldGetEpicSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        int expectedId = 55;
        String[] expectedSubtasks = {"Молоко", "Яйца", "Хлеб"};

        Assertions.assertEquals(expectedId, epic.getId());
        Assertions.assertArrayEquals(expectedSubtasks, epic.getSubtasks());
    }

    @Test
    public void shouldGetMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        int expectedId = 555;
        String expectedTopic = "Выкатка 3й версии приложения";
        String expectedProject = "Приложение НетоБанка";
        String expectedStart = "Во вторник после обеда";

        Assertions.assertEquals(expectedId, meeting.getId());
        Assertions.assertEquals(expectedTopic, meeting.getTopic());
        Assertions.assertEquals(expectedProject, meeting.getProject());
        Assertions.assertEquals(expectedStart, meeting.getStart());
    }
}
