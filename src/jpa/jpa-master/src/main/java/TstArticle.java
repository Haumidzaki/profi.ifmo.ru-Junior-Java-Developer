import entity.Article;
import entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TstArticle {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Author author = new Author();
        author.setName("qwe");

        manager.persist(author);

        for (int i = 1; i < 4; i++) {
            Article article = new Article();
            article.setTitle("Статья: " + i);
            article.setAuthor(author);

            author.getArticles().add(article);

            manager.persist(article);

        }

        manager.getTransaction().commit();

        Author author1 = manager.find(Author.class, 1);
        List<Article> articles = manager.find(Author.class, 1).getArticles();

        for (Article article: articles){
            System.out.println(article);
            article.setTitle("Новое название: " + article.getId());
        }

        manager.getTransaction().begin();
        manager.merge(author);
        manager.getTransaction().commit();
    }
}
