package be.plutus.core.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class DateServiceImpl implements DateService{

    @Override
    public Date getDate(){
        return Date.from( ZonedDateTime.now( ZoneId.of( "GMT" ) ).toInstant() );
    }
}
