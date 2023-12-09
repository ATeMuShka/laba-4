package org.Excel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {
    int id;
    String name;
    Gender gender;
    Date date;
    Division division;
    int salary;

    public Human(int id, String name, Gender gender, Date date, Division division, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.division = division;
        this.salary = salary;
    }

    public void print() {
        String format = "MM.dd.yyyy";
        DateFormat df = new SimpleDateFormat(format);

        System.out.println(id + "  ");
        System.out.print(name + "  ");
        System.out.print(gender + "  ");
        System.out.print(df.format(date) + "  ");
        System.out.print(division.getName() + "  ");
        System.out.print(salary + "  ");
    }
}
