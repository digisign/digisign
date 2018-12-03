package com.example.digital.util;



import com.example.digital.common.ErrorMessages;
import com.example.digital.exception.DigiSignException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static Date parseToDate(String date){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
           throw new DigiSignException(ErrorMessages.WRONG_DATE_FORMAT.getReasonPhrase(),ErrorMessages.WRONG_DATE_FORMAT.getCode());
        }
    }

}
