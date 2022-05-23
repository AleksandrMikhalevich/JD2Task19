package courses.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Class Course
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "hours")
    private String hours;

    /**
     * Connection with table "Student"
     */
    @ManyToMany(mappedBy = "courses",fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private Set<Student> students = new HashSet<>();

    /**
     * Connection with table "Teacher"
     */
    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private List<Teacher> teachers = new ArrayList<>();

    /**
     * Connection with table "Task"
     */
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Task> tasks = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id)
                && Objects.equals(description, course.description)
                && Objects.equals(hours, course.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, hours);
    }
}
