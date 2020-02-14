package ru.job4j.servlets.crud.persistent.db;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseCommonPool {
    private final static BaseCommonPool INSTANCE = new BaseCommonPool();
    private final BasicDataSource source = new BasicDataSource();
    private static final String DB_NAME = "users";

    private BaseCommonPool() {
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://127.0.0.1:5432/" + DB_NAME);
        source.setUsername("postgres");
        source.setPassword("password");
        source.setMinIdle(5);
        source.setMaxIdle(10);
        source.setMaxOpenPreparedStatements(100);
    }

    public static BaseCommonPool getInstance() {
        return INSTANCE;
    }

    public Connection getConnect() throws SQLException {
        return source.getConnection();
    }
}
