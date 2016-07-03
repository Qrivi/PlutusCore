package be.plutus.core.repository;

import be.plutus.core.model.token.Request;
import be.plutus.core.model.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{
}
