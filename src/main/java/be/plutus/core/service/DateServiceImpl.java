package be.plutus.core.service;

import be.plutus.core.config.Config;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class DateServiceImpl implements DateService{

    @Override
    public ZonedDateTime now(){
        return ZonedDateTime.now( Config.DEFAULT_TIMEZONE );
    }

    @Override
    public ZonedDateTime convert( Date date ){
        return ZonedDateTime.ofInstant( date.toInstant(), Config.DEFAULT_TIMEZONE );
    }
}
