package be.plutus.core.service;

import be.plutus.core.model.account.User;
import be.plutus.core.model.currency.Currency;
import be.plutus.core.model.location.Location;
import be.plutus.core.model.transaction.Transaction;
import be.plutus.core.model.transaction.TransactionType;
import be.plutus.core.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

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
}
