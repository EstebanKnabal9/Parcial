package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static Connection connection;

    public static final String URL = System.getenv("DB_URL");
    public static final String USER = System.getenv("DB_USER");
    public static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {
        if (connection == null) {
            try {
                if (URL == null || USER == null || PASSWORD == null) {
                    throw new RuntimeException("Variables de entorno para conexión a la base de datos no están definidas.");
                }

                // Registrar el driver (si es necesario)
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión exitosa!");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Error de conexión: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}