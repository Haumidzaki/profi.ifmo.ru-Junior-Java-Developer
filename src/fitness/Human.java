package fitness;

public class Human {
    protected String name;
    private String surname;
    private int bYear;
    private String regDate;

    public Human(String name, String surname, int bYear, String regDate) {
        this.name = name;
        this.surname = surname;
        this.bYear = bYear;
        this.regDate = regDate;
    }

    public Human(String name, String surname, int bYear) {
        this.name = name;
        this.surname = surname;
        this.bYear = bYear;
        this.regDate = "12.04.1019";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
