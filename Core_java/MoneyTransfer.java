
import java.sql.*;

public class MoneyTransfer {

    static final String DB_URL = "jdbc:mysql://localhost:3306/yourdb"; // change yourdb
    static final String USER = "root";
    static final String PASS = "yourpassword";

    public static void transferMoney(int fromId, int toId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            conn.setAutoCommit(false); // Start transaction

            try (
                PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                PreparedStatement creditStmt = conn.prepareStatement(creditSQL)
            ) {
                // Debit
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                int debitResult = debitStmt.executeUpdate();

                // Credit
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                int creditResult = creditStmt.executeUpdate();

                // Check if both operations succeeded
                if (debitResult == 1 && creditResult == 1) {
                    conn.commit(); // Commit the transaction
                    System.out.println("Transaction successful!");
                } else {
                    conn.rollback(); // Rollback on partial success
                    System.out.println("Transaction failed: rolling back.");
                }

            } catch (SQLException e) {
                conn.rollback(); // Rollback on any exception
                System.out.println("Error during transaction: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    // You can test it with:
    public static void main(String[] args) {
        transferMoney(1, 2, 100.00); // Transfer ₹100 from account 1 to 2
    }
}
