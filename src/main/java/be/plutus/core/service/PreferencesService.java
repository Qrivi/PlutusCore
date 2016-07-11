package be.plutus.core.service;

import be.plutus.core.model.preferences.Preferences;

public interface PreferencesService{

    Preferences getPreferenceFromAccount( int id );

    Preferences addPreference( int id , String key, String value );
}
