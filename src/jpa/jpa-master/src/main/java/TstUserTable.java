import entity.UserTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TstUserTable {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // добавление
//        UserTable userTable = new UserTable();
//        userTable.setLogin("asd");
//
//        entityManager.persist(userTable);

        // получение пользователя
        UserTable userFromDb = entityManager.find(UserTable.class, 1);
        System.out.println(userFromDb.getLogin());

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
