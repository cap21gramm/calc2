package org.example.calc2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveCalculation(Calculation calc) {
        String sql = "INSERT INTO history (num1, num2, operation, result) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, calc.getNum1());
            pstmt.setDouble(2, calc.getNum2());
            pstmt.setString(3, calc.getOperation());
            pstmt.setDouble(4, calc.getResult());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Calculation> loadHistory() {
        List<Calculation> history = new ArrayList<>();
        String sql = "SELECT num1, num2, operation, result FROM history ORDER BY id DESC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Calculation calc = new Calculation(
                        rs.getDouble("num1"),
                        rs.getDouble("num2"),
                        rs.getString("operation"),
                        rs.getDouble("result")
                );
                history.add(calc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
}