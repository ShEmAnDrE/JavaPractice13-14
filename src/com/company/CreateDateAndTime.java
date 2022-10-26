package com.company;

import java.util.Date;
import java.util.GregorianCalendar;

public class CreateDateAndTime {
    private final int[] quantityOfDaysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private Date date;
    private GregorianCalendar calendar;

    public CreateDateAndTime(String date, String time) throws InvalidDateException, InvalidTimeException {
        if (checkDate(date)) {
            if (checkTime(time)) {
                this.date = createDate(date, time);
                this.calendar = createCalendar(date, time);
            } else {
                throw new InvalidTimeException("Неверное время");
            }
        } else {
            throw new InvalidDateException("Неверная дата!");
        }
    }

    private boolean checkYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private boolean checkDate(String date) {

        if (date.length() < 5) {
            return false;
        }
        day = Integer.parseInt(date.substring(date.length()-2));
        month = Integer.parseInt(date.substring(date.length()-4, date.length()-2));
        year = Integer.parseInt(date.substring(0, date.length()-4));
        if (month > 12) {
            return false;
        }
        if (month == 2) {
            if (checkYear(year)) {
                if (day > 29) {
                    return false;
                }
            } else {
                if (day > 28) {
                    return false;
                }
            }
        } else {
            if (day > quantityOfDaysInMonths[month - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkTime(String time){
        if (time.length() > 4) {
            return false;
        }
        hour = Integer.parseInt(time.substring(0,2));
        minute = Integer.parseInt(time.substring(2));
        if (hour > 23) {
            return false;
        }
        if (minute > 59) {
            return false;
        }
        return true;
    }

    private Date createDate(String date, String time) {
        return new Date(year-1900, month-1, day, hour, minute);
    }

    private GregorianCalendar createCalendar(String date, String time) {
        return new GregorianCalendar(year, month-1, day, hour, minute);
    }

    public Date getDate() {
        return date;
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }
}
