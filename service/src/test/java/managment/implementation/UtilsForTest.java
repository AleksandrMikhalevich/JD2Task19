package managment.implementation;

import courses.entity.Course;
import courses.entity.Task;
import courses.entity.Teacher;

import java.util.Set;

import static managment.implementation.ConstantsForTest.*;

public class UtilsForTest {


    public static Course getCourse1() {
        return Course.builder()
                .description(DESCRIPTION_COURSE_1)
                .hours(HOURS_COURSE)
                .build();
    }

    public static Course getCourse2() {
        return Course.builder()
                .id(COURSE_ID)
                .description(DESCRIPTION_COURSE_2)
                .hours(HOURS_COURSE)
                .build();
    }

    public static Task getTask() {
        return Task.builder()
                .description(TASK_DESC_1)
                .build();
    }

    public static Task getTaskForDelTest() {
        return Task.builder()
                .description(TASK_DESC_2)
                .build();
    }

    public static Teacher getTeacher() {
        return Teacher.builder()
                .name(TEACHER_NAME)
                .surname(TEACHER_SURNAME)
 //               .courses(Set.of(getCourse1(),getCourse2()))
                .build();
    }
}
