package LoginSystem;

import java.sql.SQLException;

public interface Login {
    boolean login(String username,String password) throws SQLException;
}
