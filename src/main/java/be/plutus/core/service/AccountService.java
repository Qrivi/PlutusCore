package be.plutus.core.service;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.account.User;
import be.plutus.core.model.currency.Currency;
import be.plutus.core.model.location.Institution;

public interface AccountService{

    Account getAccount( int id );

    Account getAccount( String email );

    Account createAccount( String email, String password, Currency defaultCurrency );

    User createUser( int id, String firstName, String lastName, String username, String password, Institution institution );

    void removeUserFromAccount( int id, int index );

    void removeAllUsersFromAccount( int id );

    void resetTransactionsFromUser( int id );

    void updateAccount( int id, String email, String password, Currency defaultCurrency );

    void removeAccount( int id );

    void updateUser( int id, String password );
}
