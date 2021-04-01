package ma.fstg.projectgrp4seca.service.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date modifyMonth(Date date,int month){
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

}
