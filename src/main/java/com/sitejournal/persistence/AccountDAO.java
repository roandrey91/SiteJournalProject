package com.sitejournal.persistence;

import com.sitejournal.data.Account;

/**
 * @author Muresan Andrei
 * */

public interface AccountDAO {

    /**
     * @author Muresan Andrei
     * @param id
     * This method will find Account by sending an id
     * */
    Account findAccountById(long id);

    /**
     * @author Muresan Andrei
     * @param email
     * This method will find Account by using email.
     * */
    Account findAccountByEmail(String email);

    /**
     * @author Muresan Andrei
     * @param account
     * Save Account in db.
     * */
    Account saveAccount(Account account);

    /**
     * @author Muresan Andrei
     * @param account
     * Delete Account from db.
     * */
    void deleteAccount(Account account);

    /**
     * @author Muresan Andrei
     * Delete all Account except the Admin
     * */
    int deleteAllAccountsExceptAdmin();
}
