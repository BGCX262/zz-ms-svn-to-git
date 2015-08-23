/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-utility-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-23 上午11:34:12
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-8-23        Initailized
 */

package com.jzzms.framework.util.lang;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

/**
 * 邮戳帮助类
 * 
 */
public class TimestampUtils {
    
    private TimestampUtils() {
        
    }
    
    public static Timestamp getCurrentDate() {
        return new Timestamp(new java.util.Date().getTime());
    }
    
    public static Timestamp getCurrentDateWithoutTime() {
        return clearTimePart(getCurrentDate());
    }
    
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    
    public static Timestamp getCertainTimestamp(int year, int month, int date) {
        java.util.Calendar gc = GregorianCalendar.getInstance();
        gc.clear();
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month - 1);
        gc.set(Calendar.DATE, date);
        
        return new Timestamp(gc.getTime().getTime());
    }
    
    public static Timestamp getCertainTimestamp(int year,
                                                int month,
                                                int date,
                                                int hour,
                                                int minute,
                                                int second) {
        java.util.Calendar gc = GregorianCalendar.getInstance();
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month - 1);
        gc.set(Calendar.DATE, date);
        
        gc.set(Calendar.HOUR_OF_DAY, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, second);
        gc.set(Calendar.MILLISECOND, 0);
        
        return new Timestamp(gc.getTime().getTime());
    }
    
    /*
     * return YYYY-MM-DD
     */
    public static String TimestampToDateString(Timestamp tVal) {
        if (tVal == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(DateTimeUtils.DEFUALT_SHOT_TIME_FORMAT);
        return format.format(tVal);
    }
    
    public static String timestampToDateString(Timestamp tVal, String formatStr) {
        if (tVal == null) {
            return "";
        }
        
        if (StringUtils.isBlank(formatStr)) {
            return TimestampToDateString(tVal);
        }
        
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(tVal);
    }
    
    /*
     * when tVal = 2004-11-26 16:10:51.743 invoke ClearTimePart(t); return
     * 2004-11-26
     */
    public static Timestamp clearTimePart(Timestamp tVal) {
        java.util.Calendar gc = GregorianCalendar.getInstance();
        gc.clear();
        gc.setTime(tVal);
        
        gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
        
        return new Timestamp(gc.getTime().getTime());
    }
    
    /*
     * when tVal = 2004-11-26 16:10:51.743 invoke TimestampMove(t, 0, -3, -2);
     * return 2004-08-24 16:10:51.743
     */
    public static Timestamp timestampMove(Timestamp tVal,
                                          int year,
                                          int month,
                                          int day) {
        java.util.Calendar gc = GregorianCalendar.getInstance();
        gc.clear();
        gc.setTime(tVal);
        
        if (year != 0)
            gc.set(Calendar.YEAR, gc.get(Calendar.YEAR) + year);
        if (month != 0)
            gc.set(Calendar.MONTH, gc.get(Calendar.MONTH) + month);
        if (day != 0)
            gc.set(Calendar.DATE, gc.get(Calendar.DATE) + day);
        return new Timestamp(gc.getTime().getTime());
    }
    
    /*
     * when tVal = 2004-11-26 invoke getTimeEnd(t, 12); return 2005-11-25
     * 23:59:59.999
     */
    public static Timestamp getTimeEnd(Timestamp timestart, int monthlength) {
        java.util.Calendar gc = GregorianCalendar.getInstance();
        gc.clear();
        gc.setTime(timestart);
        if (monthlength != 0) {
            gc.set(Calendar.MONTH, gc.get(Calendar.MONTH) + monthlength);
            gc.set(Calendar.DATE, gc.get(Calendar.DATE) - 1);
            gc.set(Calendar.HOUR_OF_DAY, 23);
            gc.set(Calendar.MINUTE, 59);
            gc.set(Calendar.SECOND, 59);
            gc.set(Calendar.MILLISECOND, 999);
        }
        
        return new Timestamp(gc.getTime().getTime());
    }
    
    /**
     * @param timestart
     *            开始时间
     * @param type
     *            (Y:lengeth:表示以年为单位；M：表示以月为单位；D：表示以天为单位)
     * @param length
     *            长度
     * @return
     */
    public static Timestamp getTimeEnd(Timestamp timestart,
                                       String type,
                                       int length) {
        java.util.Calendar gc = GregorianCalendar.getInstance();
        gc.clear();
        gc.setTime(timestart);
        
        if ("Y".equals(type)) {
            gc.set(Calendar.MONTH, gc.get(Calendar.MONTH) + length * 12);
        } 
        else if ("M".equals(type)) {
            gc.set(Calendar.MONTH, gc.get(Calendar.MONTH) + length);
        }
        else if ("D".equals(type)) {
            gc.set(Calendar.MONTH, gc.get(Calendar.MONTH));
            gc.set(Calendar.DATE, gc.get(Calendar.DATE) + length);
        }
        
        if (length > 0){
            gc.set(Calendar.DATE, gc.get(Calendar.DATE) - 1);
        }
        
        gc.set(Calendar.HOUR_OF_DAY, 23);
        gc.set(Calendar.MINUTE, 59);
        gc.set(Calendar.SECOND, 59);
        gc.set(Calendar.MILLISECOND, 999);
        
        return new Timestamp(gc.getTime().getTime());
    }
    
    /**
     * 得到该月份的第一天邮戳
     * 
     * @return
     */
    public static Timestamp getMonthFirstDay(Timestamp timestart) {
        java.util.Calendar gc = GregorianCalendar.getInstance();
        
        gc.clear();
        gc.setTime(timestart);
        gc.set(Calendar.DAY_OF_MONTH, 1);
        gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
        
        return new Timestamp(gc.getTime().getTime());
    }
    
    public static int getDaysBetweenTwoDay(Timestamp timestart,
                                           Timestamp timeend) {
        int days = (int) ((timestart.getTime() - timeend.getTime())
                / (24 * 60 * 60 * 1000) + 1);
        return days;
        
    }
    
    /*
     * when tVal = 2004-11-26 invoke getTimeEndWithoutTime(t, 12); return
     * 2005-11-25 23:59:59.999
     */
    public static Timestamp getTimeEndWithoutTime(Timestamp timestart,
                                                  int monthlength) {
        return clearTimePart(getTimeEnd(timestart, monthlength));
    }
    
    /**
     * @param timestart
     *            开始时间
     * @param type
     *            (Y:lengeth:表示以年为单位；M：表示以月为单位；D：表示以天为单位)
     * @param length
     *            长度
     * @return
     */
    public static Timestamp getTimeEndWithoutTime(Timestamp timestart,
                                                  String type,
                                                  int length) {
        return clearTimePart(getTimeEnd(timestart, type, length));
    }
    
    public static Timestamp getDateEnd(Timestamp timestart,
                                       String type,
                                       int length) {
        java.util.Calendar gc = GregorianCalendar.getInstance();
        gc.clear();
        gc.setTime(timestart);
        
        if (length > 0) {
            if ("Y".equals(type)) {
                gc.set(Calendar.MONTH, gc.get(Calendar.MONTH) + length * 12);
            } 
            else if ("M".equals(type)) {
                gc.set(Calendar.MONTH, gc.get(Calendar.MONTH) + length);
            }
            else if ("D".equals(type)) {
                gc.set(Calendar.DATE, gc.get(Calendar.DATE) + length);
            }
        }
        
        gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
        return new Timestamp(gc.getTime().getTime());
    }
    
    public static void main(String[] args) {
        System.out.println(TimestampUtils.getCurrentDate());
        System.out.println(TimestampUtils.getCurrentDate());
        System.out.println(TimestampUtils.getTimeEnd(getCurrentTimestamp(),
                                                     "D",
                                                     1));
        
        System.out.println(TimestampUtils.getMonthFirstDay(getCurrentTimestamp()));
    }
    
    public static Timestamp stringToTimestamp(String strVal) {
        Timestamp dt = null;
        if (strVal != null && !strVal.equals("")) {
            if (strVal.indexOf("-") < 0) {
                strVal = "2010-01-01 " + strVal;
            }
            
            if (strVal.indexOf(":") < 0) {
                // 缺少时间部分，补上
                strVal += " 00:00:00";
            }
            
            try {
                dt = Timestamp.valueOf(strVal);
            } catch (Exception e) {
                
            }
        }
        return dt;
    }
}
