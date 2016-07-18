package be.plutus.core.service;

import be.plutus.core.config.Config;
import be.plutus.core.model.account.Account;
import be.plutus.core.model.account.AccountStatus;
import be.plutus.core.model.account.Credit;
import be.plutus.core.model.account.User;
import be.plutus.core.model.location.Institution;
import be.plutus.core.model.preferences.Preferences;
import be.plutus.core.model.currency.Currency;
import be.plutus.core.model.transaction.Transaction;
import be.plutus.core.repository.AccountRepository;
import be.plutus.core.repository.PreferencesRepository;
import be.plutus.core.repository.TransactionRepository;
import be.plutus.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PreferencesRepository preferencesRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Account getAccount( int id ){
        return accountRepository.findOne( id );
    }

    @Override
    public Account getAccount( String email ){
        return accountRepository.findByEmail( email );
    }

    @Override
    public Account createAccount( String email, String password, Currency defaultCurrency ){
        Account account = new Account();

        account.setEmail( email );
        account.setPlainTextPassword( password );
        account.setStatus( AccountStatus.ACTIVE );
        account.setCreationDate( new Date() );

        if( defaultCurrency == null )
            account.setDefaultCurrency( Config.DEFAULT_CURRENCY );
        else
            account.setDefaultCurrency( defaultCurrency );

        account = accountRepository.save( account );

        Preferences preferences = new Preferences();
        preferences.setAccount( account );
        preferencesRepository.save( preferences );

        return account;
    }

    @Override
    public User createUser( int id, String firstName, String lastName, String username, String password, Institution institution ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        Credit credit = new Credit();
        credit.setAmount( 0 );
        credit.setCurrency( account.getDefaultCurrency() );

        User user = new User();
        user.setAccount( account );
        user.setFirstName( firstName );
        user.setLastName( lastName );
        user.setUsername( username );
        user.setPassword( password ); // Todo encrypt password
        user.setInstitution( institution );
        user.setCreationDate( new Date() );
        user.setCredit( credit );

        return userRepository.save( user );
    }

    @Override
    public void removeUserFromAccount( int id, int index ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        User user = account.getUsers().get( index );

        if( user == null )
            throw new NullPointerException( "User with index " + index + " was not found" );

        userRepository.delete( user );
    }

    @Override
    public void removeAllUsersFromAccount( int id ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        for (int i = 0; i < account.getUsers().size(); i++)
            userRepository.delete( account.getUsers().get( i ) );
    }

    @Override
    public void resetTransactionsFromUser( int id ){
        User user = userRepository.findOne( id );

        if( user == null )
            throw new NullPointerException( "User with id " + id + " was not found" );

        user.setFetchDate( null );
        userRepository.save( user );

        List<Transaction> transactions = transactionRepository.findAllByUser( user );

        for( Transaction transaction : transactions )
            transactionRepository.delete( transaction );
    }

    @Override
    public void updateAccount( int id, String email, String password, Currency defaultCurrency ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        if( email != null )
            account.setEmail( email );
        if( password != null )
            account.setPlainTextPassword( password );
        if( defaultCurrency != null )
            account.setDefaultCurrency( defaultCurrency );

        accountRepository.save( account );
    }

    @Override
    public void removeAccount( int id ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        accountRepository.delete( account );
    }

    @Override
    public void updateUser( int id, String password ){
        User user = userRepository.findOne( id );

        if( user == null )
            throw new NullPointerException( "User with id " + id + " was not found" );

        if( password != null )
            user.setPassword( password ); // Todo encrypt password

        userRepository.save( user );
    }
}
