package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        User user = findByPassport(srcPassport);
        List<Account> list = getAccounts(user);
        if (users.putIfAbsent(user, list) != null) {
            if (list.contains(findByRequisite(srcPassport, srcRequisite))
                    && list.contains(findByRequisite(destPassport, destRequisite))) {
                for (Account account : list) {
                    if (account.getRequisite().equals(srcRequisite)) {
                        if (account.getBalance() < amount) {
                            return false;
                        }
                        account.setBalance(account.getBalance() - amount);
                    }
                    if (account.getRequisite().equals(destRequisite)) {
                        account.setBalance(account.getBalance() + amount);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
