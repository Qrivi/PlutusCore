package be.plutus.core.service;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.currency.Currency;

public interface AccountService{

    Account getAccount( int id );

    Account getAccount( String email );

    Account createAccount( String email, String password, Currency defaultCurrency );

    void updateAccount( int id, String email, String password, Currency defaultCurrency );

    void removeAccount( int id );
}
