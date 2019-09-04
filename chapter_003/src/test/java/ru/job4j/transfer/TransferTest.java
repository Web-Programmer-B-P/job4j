package ru.job4j.transfer;

import org.junit.Test;
import ru.job4j.transfer.model.Account;
import ru.job4j.transfer.model.User;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransferTest {
    @Test
    public void createNewUserAndCheckHim() {
        Transfer interfaces = new Transfer();
        User input = new User("Vitaliy", "245-lz");
        interfaces.addUser(input);
        boolean result = interfaces.getUser(input);
        assertThat(result, is(true));
    }

    @Test
    public void deleteUserFromMap() {
        Transfer interfaces = new Transfer();
        User input = new User("Inakentiy", "77-rus");
        interfaces.addUser(input);
        interfaces.deleteUser(input);
        boolean result = interfaces.getUser(input);
        assertThat(result, is(false));
    }

    @Test
    public void checkMethodGetUserAccounts() {
        Transfer interfaces = new Transfer();
        User irina = new User("Irina", "95322-gilza");
        Account account = new Account(2324034.15, "sber: 232454545, count: 4567");
        Account account1 = new Account(2456213.65, "tinkof: 7777777, count: 666");
        interfaces.addUser(irina);
        interfaces.addAccountToUser(irina.getPassport(), account);
        interfaces.addAccountToUser(irina.getPassport(), account1);
        String excpected = "[Account{value=2324034.15, requisites='sber: 232454545, count: 4567'},"
                + " Account{value=2456213.65, requisites='tinkof: 7777777, count: 666'}]";
        List<Account> result = interfaces.getUserAccounts(irina.getPassport());
        assertThat(result.toString(), is(excpected));
    }

    @Test
    public void addAccountToUserThanCheckIt() {
        Transfer interfaces = new Transfer();
        User input = new User("Olesya", "158-mol");
        Account account = new Account(20034.45, "sber: 232454545, count: 4567");
        Account account1 = new Account(2555.45, "tinkof: 7777777, count: 666");
        interfaces.addUser(input);
        interfaces.addAccountToUser(input.getPassport(), account);
        interfaces.addAccountToUser(input.getPassport(), account1);
        List<Account> result = interfaces.getUserAccounts(input.getPassport());
        String excpected = "[Account{value=20034.45, requisites='sber: 232454545, count: 4567'},"
                + " Account{value=2555.45, requisites='tinkof: 7777777, count: 666'}]";
        assertThat(result.toString(), is(excpected));
    }

    @Test
    public void deleteAccountFromUser() {
        Transfer interfaces = new Transfer();
        User input = new User("Igor", "29342-zzzdate");
        Account account = new Account(21343434.25, "houm: 35348, count: 991294");
        Account account1 = new Account(10000.01, "gazprom: 9003594, count: 282828");
        interfaces.addUser(input);
        interfaces.addAccountToUser(input.getPassport(), account);
        interfaces.addAccountToUser(input.getPassport(), account1);
        interfaces.deleteAccountFromUser(input.getPassport(), account);
        List<Account> result = interfaces.getUserAccounts(input.getPassport());
        String excpected = "[Account{value=10000.01, requisites='gazprom: 9003594, count: 282828'}]";
        assertThat(result.toString(), is(excpected));
    }

    @Test
    public void checkMethodTransfer() {
        Transfer interfaces = new Transfer();
        User evgeniy = new User("Evgeniy", "zayac-111111");
        User vasiliy = new User("Vasiliy", "ecma-222222");
        Account accountEvg = new Account(20034.45, "privat: 3333445, count: 24234-5435-5464");
        Account accountVas = new Account(2555.45, "renisans: 34596903, count: 3123-4556454-3344");
        interfaces.addUser(evgeniy);
        interfaces.addUser(vasiliy);
        interfaces.addAccountToUser(evgeniy.getPassport(), accountEvg);
        interfaces.addAccountToUser(vasiliy.getPassport(), accountVas);
        boolean tranzaction = interfaces.transferMoney(evgeniy.getPassport(), accountEvg.getRequisites(),
                vasiliy.getPassport(), accountVas.getRequisites(), 20034.45);
        assertThat(tranzaction, is(true));
    }

    @Test
    public void createNewAccountAndCheckIt() {
        Account input = new Account(259.00, "bik: 456577757575775, inn: 345345-454");
        assertThat(input.toString(), is("Account{value=259.0, requisites='bik: 456577757575775, inn: 345345-454'}"));
    }
}
