package be.plutus.repository;

import be.plutus.core.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer>{

    Account findByEmail( String email );
}
