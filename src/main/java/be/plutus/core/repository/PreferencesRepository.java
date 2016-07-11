package be.plutus.core.repository;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.preferences.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences, Integer>{
    Preferences findByAccount( Account account );
}
