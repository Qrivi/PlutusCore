package be.plutus.repository;

import be.plutus.core.account.User;
import be.plutus.core.location.Location;
import be.plutus.core.transaction.Transaction;
import be.plutus.core.transaction.TransactionType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

    List<Transaction> findByUser( User user, Pageable pageable );
    List<Transaction> findByLocation( Location location, Pageable pageable );
    List<Transaction> findByUserAndLocation( User user, Location location, Pageable pageable );
    List<Transaction> findByUserAndType( User user, TransactionType type, Pageable pageable );
}
