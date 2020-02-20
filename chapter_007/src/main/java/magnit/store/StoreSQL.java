package magnit.store;

import magnit.Config;
import magnit.xml.StoreXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class StoreSql
 *
 * @author Petr B.
 * @since 12.11.2019, 13:07
 */
public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;
    private static final String CREATE_TABLE = "CREATE TABLE entry (fieldId INTEGER)";
    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());

    public StoreSQL(Config config) {
        this.config = config;
    }

    public boolean init() {
        config.init();
        File findFileDb = new File(StoreSQL.class.getResource("/") + config.get("dbName"));
        if (!findFileDb.exists()) {
            try {
                connect = DriverManager.getConnection(config.get("driver") + config.get("dbName"));
                if (connect != null) {
                    DatabaseMetaData meta = connect.getMetaData();
                    LOG.info("The driver name is " + meta.getDriverName());
                    LOG.info("A new database has been created.");
                }
            } catch (SQLException e) {
                LOG.trace(e.getMessage());
            }
        } else {
            try {
                connect = DriverManager.getConnection(
                        config.get("driver") + StoreSQL.class.getResource("/") + config.get("dbName"));
                LOG.info("Your connection to database is successfull!");
            } catch (SQLException e) {
                LOG.trace(e.getMessage());
            }
        }
        return connect != null;
    }

    public void generate(int size) {
        try {
            DatabaseMetaData dm = connect.getMetaData();
            String[] type = {"TABLE"};
            try (ResultSet rs = dm.getTables(null, null, "entry", type)) {
                if (!rs.next()) {
                    createTableIfDoesNotExist(size);
                } else {
                    cleanTableIfExistAndInsert(size);
                }
            } catch (SQLException e) {
                LOG.trace(e.getMessage());
            }

        } catch (SQLException e) {
            LOG.trace(e.getMessage());
        }
    }

    public List<StoreXML.Field> load() {
        List<StoreXML.Field> result = new ArrayList<>();
        try (Statement st = connect.createStatement()) {
            ResultSet res = st.executeQuery("SELECT * FROM entry");
            while (res.next()) {
                result.add(new StoreXML.Field(res.getInt(1)));
            }
        } catch (SQLException e) {
            LOG.trace(e.getMessage());
        }
        return result.isEmpty() ? Collections.EMPTY_LIST : result;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    private void createTableIfDoesNotExist(int number) {
        try (Statement create = connect.createStatement()) {
            int exist = create.executeUpdate(CREATE_TABLE);
            if (exist == 0) {
                LOG.info("Table created");
                sqlInsert(number);
                LOG.info("data successfull inserted!");
            }
        } catch (SQLException e) {
            LOG.trace(e.getMessage());
        }
    }

    private void cleanTableIfExistAndInsert(int number) {
        try (Statement create = connect.createStatement()) {
            int exist = create.executeUpdate("DELETE FROM entry");
            if (exist == 0 || exist > 0) {
                sqlInsert(number);
                LOG.info("data successfull inserted!");
            }
        } catch (SQLException e) {
            LOG.trace(e.getMessage());
        }
    }

    private void sqlInsert(int number) throws SQLException {
        connect.setAutoCommit(false);
        Savepoint savepointOne = connect.setSavepoint("SavepointOne");
        try (PreparedStatement in = connect.prepareStatement("INSERT INTO entry (fieldId) VALUES (?)")) {
            for (int i = 1; i <= number; i++) {
                in.setInt(1, i);
                in.addBatch();
            }
            in.executeBatch();
        } catch (SQLException e) {
            LOG.trace(e.getMessage());
            connect.rollback(savepointOne);
        }
        connect.commit();
    }
}
