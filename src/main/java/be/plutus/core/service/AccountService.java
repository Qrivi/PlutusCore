package be.plutus.core.service;

import be.plutus.core.model.account.Account;

public interface AccountService{

    Account getAccount( int id );

    Account getAccount( String email );

    Account createAccount( String email, String password );

    void updateAccount( int id, String newEmail, String newPassword );

    void removeAccount( int id );
}
