package courses.dao;

import courses.entity.Course;
import courses.entity.Teacher;
import courses.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EntityDaoImplCourse extends EntityDaoImpl<Course> {
    private static EntityManager em;

    public EntityDaoImplCourse() {
        super(Course.class);
    }

    public List<Teacher> showTeachersForCourse(Integer courseId) {
        Query query = em.createQuery("SELECT c.teachers FROM Course c " +
                "where c.id = :courseId ");
        query.setParameter("courseId", courseId);
        return query.getResultList();
    }
}
