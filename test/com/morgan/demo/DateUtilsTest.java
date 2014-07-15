package com.morgan.demo;

import java.util.Calendar;

import junit.framework.TestCase;

import com.morgan.library.utils.DateUtils;

public class DateUtilsTest extends TestCase{

    public void testDateToString() {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.YEAR, 2014);
    	calendar.set(Calendar.MONTH, 2);//月份从0开始的
    	calendar.set(Calendar.DAY_OF_MONTH, 6);
        assertEquals("2014-03-06", DateUtils.dateToString(calendar.getTime(), DateUtils.DATE_ONLY_FORMAT));
    }
}
