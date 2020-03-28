package ru.job4j.cars.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.cars.models.Car;
import java.util.function.Consumer;
import java.util.function.Function;

public class CarDao {
    private static final Logger LOG = LogManager.getLogger(CarDao.class.getName());
    private static final CarDao INSTANCE = new CarDao();
    private static final String ERROR_MESSAGE_ADD = "Смотри в добавление нового автомобиля";
    private static final String ERROR_MESSAGE_DELETE = "Смотри в удаление записи";

    private CarDao() {

    }

    public static CarDao getInstance() {
        return INSTANCE;
    }

    public void add(Car car) {
        transactionWithOutResult(
                session -> session.save(car),
                ERROR_MESSAGE_ADD
        );
    }

    public void delete(Car car) {
        transactionWithOutResult(session -> session.delete(car),
                ERROR_MESSAGE_DELETE
        );
    }

    public void deleteAll() {
        transactionWithOutResult(session -> session.createQuery("delete from Car").executeUpdate(),
                ERROR_MESSAGE_DELETE
        );
    }

    public void update(Car car) {
        transactionWithOutResult(
                session -> session.saveOrUpdate("Car", car),
                ERROR_MESSAGE_ADD
        );
    }

    public Car get(Car car) {
        return transactionWithResult(
                session -> {
                  return session.get(Car.class, car.getId());
                },
                "Смотри в поиск записи"
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
