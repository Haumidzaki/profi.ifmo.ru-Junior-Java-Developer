package db;

import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createTable();
//
//        insertIntoBook("Книга 1", 345);
//        insertIntoBook("Книга 2", 123);
//        insertIntoBook("Книга 3", 67);
//        insertIntoBook("Книга 4", 12);
//        insertIntoBook("Книга 5", 89);

        selectAll();
    }

    public static void createTable() throws ClassNotFoundException, SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Book (\n" +
                "    id SERIAL PRIMARY KEY,\n" +
                "    title TEXT NOT NULL, \n" +
                "    pageCount INTEGER NOT NULL\n" +
                ");";
        // регистрация драйвера
        Class.forName("org.postgresql.Driver");
//        Class.forName("org.sqlite.JDBC");
        // выполняем подключение
//        "jdbc:sqlite:example.db"
        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleDB", "root", "root")){
            try (Statement statement = connection.createStatement()){
                int res = statement.executeUpdate(sqlCreate);
                System.out.println(res);
            }
        }
    }


    public static void insertIntoBook(String title, int pageCount) throws ClassNotFoundException, SQLException {
        String sqlInsert = "INSERT INTO Book (title, pageCount) VALUES (?, ?);";

        Class.forName("org.postgresql.Driver");
        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleDB", "root", "root")) {
            try (PreparedStatement statement = connection.prepareStatement(sqlInsert)){
                statement.setString(1, title);
                statement.setInt(2, pageCount);
                int res = statement.executeUpdate();
                System.out.println(res);
            }
        }
    }

    public static void selectAll() throws ClassNotFoundException, SQLException {
        String sqlSelectAll = "SELECT * FROM Book";

        // регистрация драйвера
        Class.forName("org.postgresql.Driver");
//        Class.forName("org.sqlite.JDBC");
        // выполняем подключение
//        "jdbc:sqlite:example.db"
        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleDB", "root", "root")){
            try (Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(sqlSelectAll);
                while (resultSet.next()){
                    String title = resultSet.getString("title");
                    int pageCount = resultSet.getInt("pageCount");
                    System.out.println("title: " + title);
                    System.out.println("pageCount: " + pageCount);
                }
            }
        }
    }



}
