package be.plutus.core.repository;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>{
    Token findByToken( String token );
    List<Token> findByAccount( Account account );
}
