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
import java.util.List;

@WebServlet(
        name = "IndexServlet",
        urlPatterns = "/"
)
public class IndexServlet extends HttpServlet {
    private NewsRepository newsRepository;

    public IndexServlet() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrmExample");
        newsRepository = new NewsRepository(factory.createEntityManager());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello");
        RequestDispatcher view = req.getRequestDispatcher("main.jsp");
        List<News> allnews = newsRepository.getAllNews();
        System.out.println(allnews);
        req.setAttribute("allnews", allnews);
        view.forward(req, resp);
    }


}
