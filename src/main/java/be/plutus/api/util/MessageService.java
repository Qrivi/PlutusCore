package be.plutus.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageService{

    @Autowired
    MessageSource messageSource;

    public String get( String msg )
    {
        return messageSource.getMessage( msg, null, LocaleContextHolder.getLocale() );
    }

    public String get( String msg, Object[] args )
    {
        return messageSource.getMessage( msg, args, LocaleContextHolder.getLocale() );
    }
}
