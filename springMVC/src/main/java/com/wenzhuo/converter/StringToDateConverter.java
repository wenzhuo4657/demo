package com.wenzhuo.converter;



import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>{



    @Override
    public Date convert(String s) {
        //String->Date   2005-12-12
        Date date = null;
        try {

            Format simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) simpleDateFormat.parseObject(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
