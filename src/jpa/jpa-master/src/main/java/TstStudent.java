import entity.Group;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TstStudent {
    public static void main(String[] args) {
        Student qwe = new Student();
        qwe.setName("qwe");

        Student asd = new Student();
        asd.setName("asd");

        Group jjd = new Group();
        jjd.setGroupName("jjd");

        Group nodejs = new Group();
        nodejs.setGroupName("nodejs");

        qwe.getGroups().add(jjd);
        qwe.getGroups().add(nodejs);

        asd.getGroups().add(jjd);

        jjd.getStudents().add(qwe);
        jjd.getStudents().add(asd);

        nodejs.getStudents().add(qwe);

        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("OrmExample");

        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(qwe);
        entityManager.persist(asd);

        entityManager.getTransaction().commit();


        List<Student> students = entityManager.find(Group.class, 2).getStudents();
        System.out.println("Студенты группы с id = 2");
        for (Student student: students) {
            System.out.println(student.getName());
        }

        List<Group> groups = entityManager.find(Student.class, 1).getGroups();
        System.out.println("Группы студента с id = 1");
        for (Group group: groups){
            System.out.println(group.getGroupName());
        }

        entityManager.close();
        managerFactory.close();

    }
}
