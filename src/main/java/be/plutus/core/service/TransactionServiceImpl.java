package be.plutus.core.service;

import be.plutus.core.model.account.User;
import be.plutus.core.model.currency.Currency;
import be.plutus.core.model.location.Location;
import be.plutus.core.model.transaction.Transaction;
import be.plutus.core.model.transaction.TransactionType;
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
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction( String title,
                                          String description,
                                          double amount,
                                          Currency currency,
                                          TransactionType type,
                                          Location location,
                                          Date timestamp,
                                          User user ){
        Transaction transaction = new Transaction();
        transaction.setTitle( title );
        transaction.setDescription( description );
        transaction.setAmount( amount );
        transaction.setCurrency( currency );
        transaction.setType( type );
        transaction.setLocation( location );
        transaction.setTimestamp( timestamp );
        transaction.setUser( user );
        return transactionRepository.save( transaction );
    }

    @Override
    public Transaction getTransaction( int id ){
        return transactionRepository.findOne( id );
    }

    @Override
    public List<Transaction> getTransactionByUser( int id, int limit, int offset ){
        User user = userRepository.findOne( id );

        if( user == null )
            throw new NullPointerException( "User with id " + id + " was not found" );

        return transactionRepository.findByUser( user, new PageRequest( offset, limit ) );
    }

    @Override
    public List<Transaction> getTransactionByUserAndType( int id, TransactionType type, int limit, int offset ){
        User user = userRepository.findOne( id );

        if( user == null )
            throw new NullPointerException( "User with id " + id + " was not found" );

        return transactionRepository.findByUserAndType( user, type, new PageRequest( offset, limit ) );
    }
}
