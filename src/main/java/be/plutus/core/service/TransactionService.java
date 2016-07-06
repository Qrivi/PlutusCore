package be.plutus.core.service;

import be.plutus.core.model.account.User;
import be.plutus.core.model.currency.Currency;
import be.plutus.core.model.location.Location;
import be.plutus.core.model.transaction.Transaction;
import be.plutus.core.model.transaction.TransactionType;

import java.util.Date;

public interface TransactionService{
    Transaction createTransaction( String title,
                                   String description,
                                   double amount,
                                   Currency currency,
                                   TransactionType type,
                                   Location location,
                                   Date timestamp,
                                   User user);
}
