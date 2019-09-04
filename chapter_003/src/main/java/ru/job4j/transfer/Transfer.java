package ru.job4j.transfer;

import ru.job4j.transfer.model.*;

import java.util.*;

/**
 * Class Transfer
 * Класс производит все операции связанные с открытием/закрытием,
 * а так же удалением и различных операций с переводами.
 *
 * @author Petr B.
 * @since 04.09.2019
 */
public class Transfer {
    private Map<User, List<Account>> transfer = new HashMap<>();

    public void addUser(User user) {
        this.transfer.put(user, Arrays.asList());
    }

    public boolean getUser(User user) {
        return this.transfer.containsKey(user);
    }

    public void deleteUser(User user) {
        this.transfer.remove(user);
    }

    /**
     * Метод добавления счета к пользователю по паспорту
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        for (User key : this.transfer.keySet()) {
            if (key.getPassport().equals(passport)) {
                List<Account> accounts = new ArrayList<>(this.transfer.get(key));
                if (!accounts.contains(account)) {
                    accounts.add(account);
                    this.transfer.put(key, accounts);
                }
            }
        }
    }

    /**
     * Метод удаления аккаунта от конкретного пользователя по его паспорту
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.transfer.keySet()) {
            if (user.getPassport().equals(passport)) {
                List<Account> accounts = this.transfer.get(user);
                if (accounts.contains(account)) {
                    accounts.remove(account);
                    this.transfer.put(user, accounts);
                }
            }
        }
    }

    /**
     * Метод получения всех счетов по паспорту пользователя
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (User key : this.transfer.keySet()) {
            if (key.getPassport().equals(passport)) {
                accounts = new ArrayList<>(this.transfer.get(key));
            }
        }
        return accounts;
    }

    /**
     * Метод осуществляет перевод средств между счетами.
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param dstRequisite
     * @param amount
     * @return true/false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        Account src = this.findAccount(srcPassport, srcRequisite);
        Account dest = this.findAccount(destPassport, dstRequisite);
        boolean result = false;
        if (src.checkAmount(amount)) {
            src.debitAccount(amount);
            dest.refillAccount(amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод выполняет поиск аккаунта по паспорту и реквизитам
     * @param passport
     * @param requisite
     * @return Account
     */
    private Account findAccount(String passport, String requisite) {
        Account result = new Account();
        for (User user : this.transfer.keySet()) {
            if (user.getPassport().equals(passport)) {
                List<Account> accounts = new ArrayList<>(this.transfer.get(user));
                for (Account account : accounts) {
                    if (account.getRequisites().equals(requisite)) {
                        result = account;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
