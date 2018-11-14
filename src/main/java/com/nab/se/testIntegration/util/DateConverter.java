package com.nab.se.testIntegration.util;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Component
@NoArgsConstructor
public class DateConverter {

    private static final String NLINK_TIME_ZONE_ID = "Australia/Sydney";

    public String formatForFrontEnd(Calendar date) {
        ZonedDateTime zdt = date.toInstant().atZone(ZoneId.of(NLINK_TIME_ZONE_ID));
        return zdt.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String formatAsIsoOffsetDateTime(Calendar date) {
        ZonedDateTime zdt = date.toInstant().atZone(ZoneId.of(NLINK_TIME_ZONE_ID));
        return zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
