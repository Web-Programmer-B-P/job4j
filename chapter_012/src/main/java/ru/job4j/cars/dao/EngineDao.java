package ru.job4j.cars.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.cars.models.Engine;
import java.util.function.Consumer;
import java.util.function.Function;

public class EngineDao {
    private static final Logger LOG = LogManager.getLogger(EngineDao.class.getName());
    private static final EngineDao INSTANCE = new EngineDao();
    private static final String ERROR_MESSAGE_ADD = "Смотри в добавление нового мотора";
    private static final String ERROR_MESSAGE_DELETE = "Смотри в удаление записи";

    private EngineDao() {

    }

    public static EngineDao getInstance() {
        return INSTANCE;
    }

    public void add(Engine engine) {
        transactionWithOutResult(
                session -> session.save(engine),
                ERROR_MESSAGE_ADD
        );
    }

    public void delete(Engine engine) {
        transactionWithOutResult(session -> session.delete(engine),
                ERROR_MESSAGE_DELETE
        );
    }

    public void deleteAll() {
        transactionWithOutResult(session -> session.createQuery("delete from Engine").executeUpdate(),
                ERROR_MESSAGE_DELETE
        );
    }

    public Engine get(Engine engine) {
        return transactionWithResult(
                session -> {
                    return session.get(Engine.class, engine.getId());
                },
                "Смотри в поиск записи"
        );
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
}
