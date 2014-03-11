package com.morgan.demo;

import java.util.Date;

import com.morgan.library.utils.DateUtils;

import junit.framework.TestCase;

public class DateUtilsTest extends TestCase{

    public void testDateToString() {
        assertEquals("2014-03-06", DateUtils.dateToString(new Date(), DateUtils.DATE_ONLY_FORMAT));
    }
}
