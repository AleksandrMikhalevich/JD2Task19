package courses.dao;

import courses.entity.Student;
import courses.entity.Task;
import courses.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EntityDaoImplStudent extends EntityDaoImpl<Student> {

    public EntityDaoImplStudent() {
        super(Student.class);
    }

    public List<Student> findAllStudents() {
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteria.from(Student.class);
        criteria.select(studentRoot);
        return em.createQuery(criteria).getResultList();
    }
}
