package servlets;

import entity.News;
import repositories.NewsRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "AddNewsServlet",
        urlPatterns = "/addNews"
)
public class AddNewsServlet extends HttpServlet {
    private NewsRepository newsRepository;

    public AddNewsServlet() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrmExample");
        newsRepository = new NewsRepository(factory.createEntityManager());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("addNews.jsp");
        req.setAttribute("addinfo", "Для добавления статьи заполните форму");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        News news = new News();
        news.setTitle(title);
        news.setNewsText(description);

        newsRepository.addNews(news);
        RequestDispatcher view = req.getRequestDispatcher("addNews.jsp");
        req.setAttribute("addinfo", "Статья '" + title + "' добавлена, можете добавить еще");
        view.forward(req, resp);


    }
}
