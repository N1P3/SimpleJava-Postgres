package data.remote.datasource;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static utils.Constants.*;

public final class DataBaseConnector {
    private static DataBaseConnector instance;
    public Connection connection;

    public DataBaseConnector(Connection connection) {
        this.connection = connection;
    }

    public static DataBaseConnector getInstance() {
        if (instance == null) {
            try {
               Connection mConnection= DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
               instance = new DataBaseConnector(mConnection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return instance;
    }
}

