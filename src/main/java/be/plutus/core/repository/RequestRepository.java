package be.plutus.core.repository;

import be.plutus.core.model.token.Request;
import be.plutus.core.model.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{
    List<Request> findByToken( Token token );
}
