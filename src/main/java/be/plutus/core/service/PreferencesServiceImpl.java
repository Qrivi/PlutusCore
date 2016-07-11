package be.plutus.core.service;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.preferences.Preferences;
import be.plutus.core.repository.AccountRepository;
import be.plutus.core.repository.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PreferencesServiceImpl implements PreferencesService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PreferencesRepository preferencesRepository;

    @Override
    public Preferences getPreferenceFromAccount( int id ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        return preferencesRepository.findByAccount( account );
    }

    @Override
    public Preferences addPreference( int id, String key, String value ){
        Preferences preferences = preferencesRepository.findOne( id );

        if( preferences == null )
            throw new NullPointerException( "Preferences with id " + id + " was not found" );

        preferences.set( key, value );

        return preferencesRepository.save( preferences );
    }
}
