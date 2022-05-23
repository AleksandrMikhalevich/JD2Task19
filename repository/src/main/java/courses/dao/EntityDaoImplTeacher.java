package courses.dao;

import courses.entity.Teacher;
import courses.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EntityDaoImplTeacher extends EntityDaoImpl<Teacher> {

    private static EntityManager em;

    public EntityDaoImplTeacher() {
        super(Teacher.class);
    }

    public void enrollTeacher(Teacher teacher) {
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(teacher);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
