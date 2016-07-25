package be.plutus.core.service;

import java.time.ZonedDateTime;
import java.util.Date;

public interface DateService{

    ZonedDateTime now();
    ZonedDateTime convert( Date date );
}
