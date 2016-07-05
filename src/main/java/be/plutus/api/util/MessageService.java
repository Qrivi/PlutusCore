package be.plutus.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageService{

    @Autowired
    MessageSource messageSource;

    public String get( String id ){
        try {
            return messageSource.getMessage( id, null, LocaleContextHolder.getLocale() );
        } catch( NoSuchMessageException e ) {
            return id;
        }
    }

    public String get( String id, Object[] args ){
        try {
            return messageSource.getMessage( id, args, LocaleContextHolder.getLocale() );
        } catch( NoSuchMessageException e ) {
            return id;
        }
    }
}
