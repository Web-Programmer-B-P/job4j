package ru.job4j.servlets.crud.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.servlets.crud.model.User;
import ru.job4j.servlets.crud.persistent.Store;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbStore implements Store {
    private static final Logger LOG = LogManager.getLogger(DbStore.class.getName());
    private static final DbStore INSTANCE = new DbStore();
    public static final String PARAMETRIZED_QUERY_WITH_PRIMARY_KEY = "user_id=?";
    public static final String TABLE_NAME = "users";
    private final BasicDataSource SOURCE = new BasicDataSource();

    private DbStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://127.0.0.1:5432/" + TABLE_NAME);
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("password");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO " + TABLE_NAME + " (name, login, email, date, image) values (?, ?, ?, ?, ?)")) {
            setCommonStatement(user, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE " + TABLE_NAME + " SET name=?, login=?, email=?, date=?, image=? WHERE "
                             + PARAMETRIZED_QUERY_WITH_PRIMARY_KEY)) {
            setCommonStatement(user, preparedStatement);
            preparedStatement.setInt(6, user.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE "
                             + PARAMETRIZED_QUERY_WITH_PRIMARY_KEY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> listOfFoundUsers = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME)) {
            while (resultSet.next()) {
                listOfFoundUsers.add(fillFoundUser(resultSet));
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        return listOfFoundUsers;
    }

    @Override
    public User findById(int id) {
        User foundUser = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement prepare = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE "
                     + PARAMETRIZED_QUERY_WITH_PRIMARY_KEY)) {
            prepare.setInt(1, id);
            ResultSet resultSet = prepare.executeQuery();
            if (resultSet.next()) {
                foundUser = fillFoundUser(resultSet);
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        return foundUser;
    }

    private User fillFoundUser(ResultSet resultSet) throws SQLException {
        int user_id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String login = resultSet.getString(3);
        String email = resultSet.getString(4);
        long date = resultSet.getDate(5).getTime();
        String image = resultSet.getString(6);
        return new User(user_id, name, login, email, image, date);
    }

    private void setCommonStatement(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getLogin());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setDate(4, new Date(System.currentTimeMillis()));
        preparedStatement.setString(5, user.getPhotoId());
    }
}
