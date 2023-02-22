package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис
 * @author Igor R.
 * @version 1.0
 */
public class BankService {
    /**
     * Поле, которое содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить нового пользователя
     * @param user пользователь, который добавляется в сервис
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить пользователя из сервиса
     * @param passport номер паспорта, который принадлежит удаляемому пользователю
     * @return возвращает true при успешном удалении, false - при неудачном
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;

    }

    /**
     * Метод позволяет добавить новый счет к пользователю,
     * для этого осуществляется поиск пользователя по паспорту,
     * если такой пользователь есть у него нет добавляемого счета,
     * то счет добавляется
     * @param passport номер паспорта пользователя
     * @param account счет, который добавляется к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти пользователя по номеру паспорта.
     * @param passport номер паспорта пользователя
     * @return возврящает найденного пользователя, если пользователь не найден то возвращает Null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод позволяет найти счет пользователя
     * @param passport паспорт пользователя
     * @param requisite реквизиты счета пользователя
     * @return возвращает счет пользователя, если пользователь или счет не найден,
     * то возвращает Null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет перевести деньги со счета одного пользователя
     * на счет другого пользователя
     * @param srcPassport номер паспорта пользователя, со счета которого осуществляется перевод
     * @param srcRequisite реквизиты счета, с которого осуществляется перевод
     * @param destPassport номер паспорта пользователя, на счет которого осуществляется перевод
     * @param destRequisite реквизиты счета, на который осуществляется перевод
     * @param amount сумма перевода
     * @return возвращает true при удачном переводе. Если какой-либо счет не найден
     * или на счете с которого осуществляется перевод недостаточно средств, то возвращается false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }

    /**
     * Метод возвращает все счета пользователя. Необходим для тестирования.
     * @param user пользователя, счета которого необходимо вернуть
     * @return List со всеми счетами пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}