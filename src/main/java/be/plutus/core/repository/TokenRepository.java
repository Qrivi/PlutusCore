package be.plutus.core.repository;

import be.plutus.core.model.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>{
    Token findByToken( String token );
}
