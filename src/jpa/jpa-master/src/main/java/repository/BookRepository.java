package repository;

import entity.Book;
import specification.Specification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookRepository implements Repository<Book, Integer> {
    private EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // добавление записи
    public void add(Book book) {
        // начали транзацкию
        entityManager.getTransaction().begin();

        entityManager.persist(book); // добавление новой записи в бд
//        INSETRT INTO Book(title, author) VALUES("Book 1", "someA");
        // подтвердили транзакцию
        entityManager.getTransaction().commit();
    }

    // обновление записи
    public void update(Book book) {
        entityManager.getTransaction().begin();
        entityManager.merge(book); // обновление существующей записи в бд
        // UPDATE book SET
        entityManager.getTransaction().commit();
    }


    // удаление записи
    public void delete(Integer integer) {
        entityManager.getTransaction().begin();

        Book book = getByPk(integer);
        entityManager.remove(book); // удаление записи из базы
//DELETE
        entityManager.getTransaction().commit();
    }

    // получение книги по id
    public Book getByPk(Integer integer) {
        return entityManager.find(Book.class, integer);
        //SELECT * FROM book WHERE id = integer
    }

    public List<Book> getAll() {
        // 1. named queries
//        TypedQuery<Book> query = entityManager.createNamedQuery("Book.findAll", Book.class);
//        List<Book> books = query.getResultList();

        // 2. JPQL
//        Query query = entityManager.createQuery("SELECT b FROM Book b");
//        List<Book> books = (List<Book>) query.getResultList();

        // 3. Criteria API
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);

        TypedQuery<Book> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Book> books = typedQuery.getResultList();

        return books;
    }


    public Book getBookByTitle(String title){
        // 1. named query
//        TypedQuery<Book> query = entityManager.createNamedQuery("Book.findByTitle", Book.class);
//        query.setParameter("title", title); // установка значения для параметра
//        Book book = query.getSingleResult();

        // 2. JPQL
//        TypedQuery<Book> query =
//                entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
//        query.setParameter("title", title);
//        Book book = query.getSingleResult();

        // 3. Criteria API
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);

        Predicate condition = criteriaBuilder.equal(root.<String>get("title"), title); //title = :title
        criteriaQuery.select(root).where(condition);// "SELECT b FROM Book WHERE title = " + title;

        TypedQuery<Book> query = entityManager.createQuery(criteriaQuery);

        Book book = query.getSingleResult();

        return book;
    }


    public List<Book> getBySpecification(Specification spec) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(spec.getType());
        Root<Book> root = criteriaQuery.from(spec.getType());

        Predicate condition = spec.toPredicate(root, criteriaBuilder);
        criteriaQuery.where(condition);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
