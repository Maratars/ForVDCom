package maratars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/MyDB1";
        String username = "root";
        String password = "14021984";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
// "товары"
            String createProductsTable = "CREATE TABLE товары ("
                    + "id INT PRIMARY KEY,"
                    + "название VARCHAR(50),"
                    + "цена DECIMAL(10, 2)"
                    + ")";
            statement.executeUpdate(createProductsTable);

// "клиенты"
            String createCustomersTable = "CREATE TABLE клиенты ("
                    + "id INT PRIMARY KEY,"
                    + "имя VARCHAR(50),"
                    + "email VARCHAR(50)"
                    + ")";
            statement.executeUpdate(createCustomersTable);

// "заказы"
            String createOrdersTable = "CREATE TABLE заказы ("
                    + "id INT PRIMARY KEY,"
                    + "id_товара INT,"
                    + "id_клиента INT,"
                    + "количество INT,"
                    + "FOREIGN KEY (id_товара) REFERENCES товары(id),"
                    + "FOREIGN KEY (id_клиента) REFERENCES клиенты(id)"
                    + ")";
            statement.executeUpdate(createOrdersTable);

            System.out.println("База данных и таблицы успешно созданы.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}