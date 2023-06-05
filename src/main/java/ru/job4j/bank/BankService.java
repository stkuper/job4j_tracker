package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса, а именно добавление, нахождение и удаление
 * пользователей, добавление, нахождение и удаление аккаунтов этих пользователей, возможность
 * перевода денег с одного аккаунта на другой
 * @author STAS KUPRIYANOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователя и списка его аккаунтов по типу ключ - значение осуществляется
     * в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает параметр user, проверяет его, есть ли он в списке и если его нет
     * производит добавление пользователя user в список
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает параметр passport, по нему находит пользователя и удаляего его
     * из коллекции users типа HashMap
     * @param passport пасспорт пользователя
     * @return возвращает true, если удаление произошло, false если нет
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает параметра passport и account. По passport находит пользователя user,
     * и проверяет есть ли у него принимаемый account, если нет добавляет его в список
     * аккаунтов пользователя user
     * @param passport пасспорт пользователя
     * @param account принимаемый аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод принимает параметр passport, по нему находит и возвращает пользователя
     * user если он есть или null если его нет
     * @param passport пасспорт пользователя
     * @return возвращает пользователя user если он есть или null если его нет
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает параметры passport и requisite, по passport находит пользователя user,
     * по нему список его аккаунтов, а из списка аккаунтов по полю requisite находит и
     * возвращает нужный аккаунт
     * @param passport пасспорт пользователя
     * @param requisite реквизит аккаунта
     * @return возвращает аккаунт account если он есть или null если его нет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account account : list) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает параметры srcPassport, srcRequisite, destPassport, destRequisite, amount
     * по этим параметрам находит аккаунты и осушествляет перевод необходимой суммы
     * между аккаунтами
     * @param srcPassport   пасспорт пользователя от которого будет перевод
     * @param srcRequisite  реквезит аккаунта с которого будет перевод
     * @param destPassport  пасспорт пользователя которому будет перевод
     * @param destRequisite реквизит аккаунта на который будет перевод
     * @param amount        сумма перевода
     * @return возвращает true если перевод произошёл, false если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод принимает пользователя user и возвращает его список аккаунтов
     * @param user пользователь
     * @return список аккаунтов этого пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
