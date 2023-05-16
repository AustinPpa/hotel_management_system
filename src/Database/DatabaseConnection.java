package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String dbName = "YOUR DATABASE NAME";
    private final String db_username = "YOUR DATABASE USERNAME";
    private final String db_password = "YOUR DATABASE PASSWORD";
    private final Connection con= DriverManager.getConnection(
            "YOUR SQL LOCAL HOST"+dbName, db_username, db_password);
    public DatabaseConnection() throws SQLException {

    }
    public Connection getCon(){
        return this.con;
    }
}
