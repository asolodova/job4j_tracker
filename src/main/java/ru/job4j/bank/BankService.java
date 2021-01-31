package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().equals(user)) {
                List<Account> accounts = entry.getValue();
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user: users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().equals(user)) {
                List<Account> accounts = entry.getValue();
                for (Account account: accounts) {
                    if (account.getRequisite().equals(requisite)) {
                        return account;
                    }
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        if (srcAccount != null) {
            Account destAccount = findByRequisite(destPassport, destRequisite);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
