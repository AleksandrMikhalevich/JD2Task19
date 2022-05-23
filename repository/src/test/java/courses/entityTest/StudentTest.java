package courses.entityTest;

import courses.dao.EntityDaoImplStudent;
import courses.entity.Course;
import courses.entity.Student;
import courses.util.HibernateUtil;
import courses.utilsTest.Utils;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import static courses.constans.ConstansStudent.*;

public class StudentTest {

    @Test
    public void jpqlStudent() {
        Course course = Utils.createCourse();
        Student student = Utils.createStudent(Set.of(course));
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(student);
        Assert.assertEquals("Student name not equals", STUDENT_NAME, student.getName());
    }

    @Test
    public void testInsertStudent() {
        Course course = Utils.createCourse();
        Student student = Utils.createStudent(Set.of(course));
        EntityDaoImplStudent daoStudent = new EntityDaoImplStudent();
        daoStudent.insert(course);
        daoStudent.insert(student);
        Assert.assertNotNull(daoStudent.getEntity(STUDENT_INSERT_ID));
    }

    @Test
    public void testDeleteStudent()
            throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException {
        Course course = Utils.createCourse();
        Student student = Utils.createStudent(Set.of(course));
        EntityDaoImplStudent daoStudent = new EntityDaoImplStudent();
        daoStudent.insert(course);
        daoStudent.insert(student);
        daoStudent.delete(student);
        Assert.assertNotNull(student);
    }

    @Test
    public void testDeleteStudentById() {
        Course course = Utils.createCourse();
        Student student = Utils.createStudent(Set.of(course));
        EntityDaoImplStudent daoStudent = new EntityDaoImplStudent();
        daoStudent.insert(course);
        daoStudent.insert(student);
        daoStudent.deleteById(STUDENT_DELETE_BY_ID);
        Assert.assertNotNull(student);
    }

    @Test
    public void testUpdateStudent() {
        Student student = Student.builder()
                .name(STUDENT_NAME)
                .surname(STUDENT_SURNAME)
                .build();
        EntityDaoImplStudent daoStudent = new EntityDaoImplStudent();
        daoStudent.insert(student);
        student.setName(STUDENT_SET_NAME);
        daoStudent.update(student);
        Assert.assertEquals(student.getName(),
                STUDENT_SET_NAME);
    }

    @Test
    public void testGetEntityStudent() {
        Course course = Utils.createCourse();
        Student student = Utils.createStudent(Set.of(course));
        EntityDaoImplStudent daoStudent = new EntityDaoImplStudent();
        daoStudent.insert(course);
        daoStudent.insert(student);
        Assert.assertNotNull(daoStudent.getEntity(STUDENT_GET_ID).toString());
    }

    @Test
    public void testFindAllStudents() {
        Course course = Utils.createCourse();
        Student student = Utils.createStudent(Set.of(course));
        Student student2 = Student.builder()
                .name(STUDENT_SET_NAME)
                .surname(STUDENT_SURNAME)
                .build();
        EntityDaoImplStudent daoStudent = new EntityDaoImplStudent();
        daoStudent.insert(course);
        daoStudent.insert(student);
        daoStudent.insert(student2);
        List<Student> students = daoStudent.findAllStudents();
        Assert.assertEquals(students.toString(), daoStudent.findAllStudents().toString());
    }
}
