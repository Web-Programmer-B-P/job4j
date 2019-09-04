package ru.job4j.transfer.model;

import java.util.Objects;

/**
 * Class Account
 *
 * @author Petr B.
 * @since 04.09.2019
 */
public class Account {
    private double value;
    private String requisites;

    public Account() {

    }

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isEmpty() {
        boolean result = true;
        if (this.getValue() > 0 && this.getRequisites() != null) {
            result = false;
        }
        return result;
    }

    /**
     * Метод проверяет статус счета
     * @param cash
     * @return true/false
     */
    public boolean checkAmount(double cash) {
        boolean status = false;
        if (this.getValue() >= cash) {
            status = true;
        }
        return status;
    }

    /**
     * Метод списания денег со счета
     * @param cash
     */
    public void debitAccount(double cash) {
        this.setValue(this.getValue() - cash);
    }

    /**
     * Метод пополнения счета
     * @param cash
     */
    public void refillAccount(double cash) {
        this.setValue(this.getValue() + cash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.value, value) == 0
                && Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites='" + requisites
                + '\''
                + '}';
    }
}
