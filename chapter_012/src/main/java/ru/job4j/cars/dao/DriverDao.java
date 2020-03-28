package ru.job4j.cars.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.cars.models.Car;
import ru.job4j.cars.models.Driver;
import java.util.function.Consumer;
import java.util.function.Function;

public class DriverDao {
    private static final Logger LOG = LogManager.getLogger(DriverDao.class.getName());
    private static final DriverDao INSTANCE = new DriverDao();
    private static final String ERROR_MESSAGE_ADD = "Смотри в добавление нового водителя";
    private static final String ERROR_MESSAGE_DELETE = "Смотри в удаление записи";

    private DriverDao() {

    }

    public static DriverDao getInstance() {
        return INSTANCE;
    }

    public void add(Driver driver) {
        transactionWithOutResult(
                session -> session.save(driver),
                ERROR_MESSAGE_ADD
        );
    }

    public Driver get(Driver driver) {
        return transactionWithResult(
                session -> {
                    return session.get(Driver.class, driver.getId());
                },
                "Смотри в поиск записи"
        );
    }

    public void delete(Driver driver) {
        transactionWithOutResult(session -> session.delete(driver),
                ERROR_MESSAGE_DELETE
        );
    }

    public void deleteAll() {
        transactionWithOutResult(session -> session.createQuery("delete from Driver").executeUpdate(),
                ERROR_MESSAGE_DELETE
        );
    }

    private void transactionWithOutResult(final Consumer<Session> command, String message) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = PoolConnection.getSession();
            transaction = session.beginTransaction();
            command.accept(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.error(message, e);
        }
    }

    private <T> T transactionWithResult(final Function<Session, T> command, String message) {
        T result = null;
        Transaction transaction = null;
        Session session = null;
        try {
            session = PoolConnection.getSession();
            transaction = session.beginTransaction();
            result = command.apply(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.error(message, e);
        }
        return result;
    }
}
