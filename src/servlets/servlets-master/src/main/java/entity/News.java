package entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String newsText;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar newsDate = new GregorianCalendar();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public String getNewsDate() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(newsDate.getTime());
    }

    public void setNewsDate(Calendar newsDate) {
        this.newsDate = newsDate;
    }
}
