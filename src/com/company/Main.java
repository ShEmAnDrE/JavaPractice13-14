package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static boolean checkYear(int year) {
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

    public static boolean checkDate(String date) {
        int[] quantityOfDaysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (date.length() < 5) {
            return false;
        }
        int day = Integer.parseInt(date.substring(date.length()-2));
        int month = Integer.parseInt(date.substring(date.length()-4, date.length()-2));
        int year = Integer.parseInt(date.substring(0, date.length()-4));
        if (month > 12) {
            return false;
        }
        if (month == 2) {
            if (checkYear(year)) {
                if (year > 29) {
                    return false;
                }
            } else {
                if (year > 28) {
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

    public static boolean checkTime(String time){
        if (time.length() > 4) {
            return false;
        }
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(2));
        if (hour > 23) {
            return false;
        }
        if (minute > 59) {
            return false;
        }
        return true;
    }

    public static Date createDate(String date, String time) {
        int day = Integer.parseInt(date.substring(date.length()-2));
        int month = Integer.parseInt(date.substring(date.length()-4, date.length()-2));
        int year = Integer.parseInt(date.substring(0, date.length()-4));
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(2));
        return new Date(year - 1970, month, day, hour, minute);
    }

    public static GregorianCalendar createCalendar(String date, String time) {
        int day = Integer.parseInt(date.substring(date.length()-2));
        int month = Integer.parseInt(date.substring(date.length()-4, date.length()-2));
        int year = Integer.parseInt(date.substring(0, date.length()-4));
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(2));
        return new GregorianCalendar(year, month, day, hour, minute);
    }

    public static void main(String[] args) {
        String date = "";
        String time = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату:");
        System.out.println("Огромная просьба писать месяца, числа, часы и минуты, если они меньше 10, в виде \"0x\"");
        System.out.println("Введите дату в формате \"<Год><Месяц><Число>\"");
        date = sc.nextLine();
        if (checkDate(date)) {
            System.out.println("Введите время в формате \"<Часы1><минуты>\"");
            time = sc.nextLine();
            if (checkTime(time)) {
                Date date1 = createDate(date, time);
                System.out.println("Создаем Date:");
                System.out.println(date1);
                Calendar calendar = createCalendar(date, time); // некорректный вывод надо исправить
                System.out.println("Создаем Calendar:");
                System.out.println(calendar.getTime());
            } else {
                System.out.println("Время некорректно");
            }
        } else {
            System.out.println("Дата некорректна");
        }
    }
}
