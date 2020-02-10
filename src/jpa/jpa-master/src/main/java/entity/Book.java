package entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table //(name = "otherName")
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
//        @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fieldName",
//            nullable = false, insertable = true, updatable = false,
//            length = 255,
            columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;
    private int pageCount;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar addDate;

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

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Calendar getAddDate() {
        return addDate;
    }

    public void setAddDate(Calendar addDate) {
        this.addDate = addDate;
    }
}
