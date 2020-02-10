package repositories;

import entity.News;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class NewsRepository {
    private EntityManager manager;

    public NewsRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void addNews(News news){
        manager.getTransaction().begin();
        manager.persist(news);
        manager.getTransaction().commit();
    }

    public News getById(int id){
        return manager.find(News.class, id);
    }

    public List<News> getAllNews(){
        TypedQuery<News> typedQuery = manager.createQuery("SELECT b FROM News b", News.class);
        return typedQuery.getResultList();
    }
}
