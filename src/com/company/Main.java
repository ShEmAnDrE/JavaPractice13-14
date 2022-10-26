package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String date = "";
        String time = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату:");
        System.out.println("Огромная просьба писать месяца, числа, часы и минуты, если они меньше 10, в виде \"0x\"");
        System.out.println("Введите дату в формате \"<Год><Месяц><Число>\"");
        date = sc.nextLine();
        System.out.println("Введите время в формате \"<Часы1><минуты>\"");
        time = sc.nextLine();
        try {
            CreateDateAndTime dateAndTime = new CreateDateAndTime(date, time);
            System.out.println("Выводим Date");
            System.out.println(dateAndTime.getDate());
            System.out.println("Выводим Calendar");
            System.out.println(dateAndTime.getCalendar().getTime());
        } catch (InvalidDateException e1) {
            System.out.println("Неверная дата!");
        } catch (InvalidTimeException e2) {
            System.out.println("Неверное время!");
        }
    }
}
