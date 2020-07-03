package com.company;

import java.util.Date;

public class DateClass {

    int month, day, year;

    // TASK 1
    public DateClass() {
        new DateClass(1,1,0);
    }

    // TASK 2
    public DateClass(int month, int day, int year) {
        this.setMonth(month);
        this.setDay(day);
        this.setYear(year);
    }

    // TASK 3
    public DateClass(int mmddyyyy) {
        new DateClass(mmddyyyy/1000000,(mmddyyyy/10000)%100,mmddyyyy%10000);
    }

    // TASK 4
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (day == 29 && this.month == 2 && !isLeapYear()) {
            System.out.println("Error! Can't set an invalid day!");
            new DateClass(0,0,0);
        }
        else if (day == 31 && (this.month == 4 ||this.month == 6 ||this.month == 9 ||this.month == 11)) {
            System.out.println("Error! Can't set an invalid day!");
            new DateClass(0,0,0);
        }
        else
            this.day = day;
    }

    public void setMonth(int month) {
        if (month < 0 || month > 12) {
            System.out.println("Error! Can't set an invalid month!");
            new DateClass(0,0,0);
        }
        else if (!this.isLeapYear() && this.getDay() == 29 && month == 2) {
            System.out.println("Error! Can't set an invalid month!");
            new DateClass(0,0,0);
        }
        else if (this.day == 31 && (month == 4 ||month == 6 ||month == 9 ||month == 11)) {
            System.out.println("Error! Can't set an invalid month!");
            new DateClass(0,0,0);
        }
        else
            this.month = month;
    }

    public void setYear(int year) {
        if (this.month == 2 && this.day == 29 && !isLeapYear()) {
            System.out.println("Error! Can't set an invalid year!");
            new DateClass(0,0,0);
        }
        else
            this.year = year;

    }

    // TASK 5
    public String monthName(int month) {
        String[] a = {"January","February","March","April","May","June","July","August",
                "September","October","November","December"};
        return a[month - 1];
    }

    // TASK 6
    @Override
    public String toString() {
        return monthName(this.month) + " " + this.day + ", " + this.year;
    }

    // TASK 7
    public Boolean isLastDayOfMonth(DateClass d) {
        if ((d.getMonth() == 4 ||d.getMonth() == 6 ||d.getMonth() == 9 ||d.getMonth() == 11) && d.getDay() == 30)
            return true;
        else if ((d.getMonth() != 4 ||d.getMonth() != 6 ||d.getMonth() != 9 ||d.getMonth() != 11||d.getMonth() != 2) && d.getDay() == 31)
            return true;
        else if (d.getMonth() == 2 && d.getDay() == 28 && (d.isLeapYear() == false))
            return true;
        else if (d.getMonth() == 2 && d.getDay() == 29 && d.isLeapYear())
            return true;
        return false;
    }

    // TASK 8
    public Boolean isBefore(DateClass d) {
        if (this.year < d.getYear())
            return true;
        else if (this.year == d.getYear() && this.month < d.getMonth())
            return true;
        else if (this.year == d.getYear() && this.month == d.getMonth() && this.day < d.getDay())
            return true;
        return false;
    }

    // TASK 9
    public Boolean isAfter(DateClass d) {
        if (this.year > d.getYear())
            return true;
        else if (this.year == d.getYear() && this.month > d.getMonth())
            return true;
        else if (this.year == d.getYear() && this.month == d.getMonth() && this.day > d.getDay())
            return true;
        return false;
    }

    // TASK 10
    public Boolean isSameDate(DateClass d) {
        if (!isAfter(d) && !isBefore(d))
            return true;
        return false;
    }

    // TASK 11
    public Boolean isLeapYear() {
        if (this.year % 4 == 0 && this.year % 100 != 0)
            return true;
        else if (this.year % 4 == 0 && this.year % 100 == 0 && this.year % 400 == 0)
            return true;
        return false;
    }

    // TASK 12
    public DateClass nextDate() {
        DateClass next = new DateClass();
        if (this.month == 12) {
            if (isLastDayOfMonth(this) == true) {
                next.setMonth(1);
                next.setDay(1);
                next.setYear(this.year + 1);
            }
            else {
                next.setMonth(this.month);
                next.setDay(this.day + 1);
                next.setYear(this.year);
            }
        }
        else {
            if (isLastDayOfMonth(this) == true) {
                next.setMonth(this.month + 1);
                next.setDay(1);
                next.setYear(this.year);
            }
            else {
                next.setMonth(this.month);
                next.setDay(this.day + 1);
                next.setYear(this.year);
            }

        }

        return next;
    }

    // TASK 13
    public DateClass prevDate() {
        DateClass next = new DateClass();
        if (this.month == 1) {
            if (this.day == 1) {
                next.setMonth(12);
                next.setDay(31);
                next.setYear(this.year - 1);
            }
            else {
                next.setMonth(this.month);
                next.setDay(this.day - 1);
                next.setYear(this.year);
            }
        }
        else {
            if (this.day == 1) {
                if (this.getMonth() - 1 != 4 && this.getMonth() - 1 != 6 && this.getMonth() - 1 != 9 && this.getMonth() - 1 != 11 &&
                        this.getMonth() - 1 != 2) {
                    next.setMonth(month - 1);
                    next.setDay(31);
                    next.setYear(this.year);
                }
                else if (this.getMonth() - 1 == 4 || this.getMonth() - 1 == 6 || this.getMonth() - 1 == 9 || this.getMonth() - 1 == 11) {
                    next.setMonth(month - 1);
                    next.setDay(30);
                    next.setYear(this.year);
                }
                else if (this.getMonth() - 1 == 2 && !isLeapYear()) {
                    next.setMonth(month - 1);
                    next.setDay(28);
                    next.setYear(this.year);
                }
                else if (this.getMonth() - 1 == 2 && isLeapYear()) {
                    next.setMonth(month - 1);
                    next.setDay(29);
                    next.setYear(this.year);
                }
            }
            else {
                next.setMonth(this.month);
                next.setDay(this.day - 1);
                next.setYear(this.year);
            }

        }

        return next;
    }

    // TASK 14
    public int daysApart(DateClass d) {
        int daysBetween = 0;
        DateClass from, to;

        if (this.isSameDate(d)) {
            return 0;
        } else {
            if (this.isBefore(d)) {
                from = this;
                to = d;
            } else {
                from = d;
                to = this;
            }
        }

        while (!from.isSameDate(to)) {
            from = from.nextDate();
            daysBetween++;
        }

        return daysBetween;
    }

    // TASK 15
    public int dayOfYear() {
        int count = 0;
        DateClass temporary = new DateClass(0,0,0);
        while (!temporary.isSameDate(this)) {
            temporary = this.nextDate();
            count ++;
        }

        return count;
    }

    // TASK 16
    public int daysLeftInMonth() {
        int daysLeft;
        DateClass temporary;

        if (isLastDayOfMonth(this))
            daysLeft = 0;
        else if (this.month == 4 ||this.month == 6 ||this.month == 9 ||this.month == 11) {
            temporary = new DateClass(this.month,30,this.year);
            daysLeft = this.daysApart(temporary);
        }
        else if (this.month != 4 ||this.month != 6 ||this.month != 9 ||this.month != 11) {
            temporary = new DateClass(this.month,31,this.year);
            daysLeft = this.daysApart(temporary);
        }
        else if (this.month == 2 && this.year % 4 == 0) {
            temporary = new DateClass(this.month,29,this.year);
            daysLeft = this.daysApart(temporary);
        }
        else {
            temporary = new DateClass(this.month,28,this.year);
            daysLeft = this.daysApart(temporary);
        }

        return daysLeft;
    }

    // TASK 17
    public int daysLeftInYear() {
        return this.daysApart(new DateClass(12,31,this.year));
    }

    // TASK 18
    public int daysLeftInDecade() {
        int year = this.year;

        while(year % 10 != 0)
            year++;
        return this.daysApart(new DateClass(12,31,year));
    }

    // TASK 19
    public int daysLeftInCentury() {
        int year = this.year;

        while(year %100 != 0)
            year++;
        return this.daysApart(new DateClass(12,31,year));
    }

    // TASK 20
    public DateClass earlierDate(DateClass d) {
        if (this.isBefore(d))
            return this;
        else if (this.isAfter(d))
            return d;
        else {
            System.out.println("The Dates are the same!");
            return new DateClass();
        }
    }

    // TASK 21
    public DateClass laterDate(DateClass d) {
        if (this.isBefore(d))
            return d;
        else if (this.isAfter(d))
            return this;
        else {
            System.out.println("The Dates are the same!");
            return new DateClass();
        }
    }

    // TASK 22
    public String dayOfTheWeek() {
        String[] a = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int num, k = this.getDay(), m = this.getMonth()-2, C = this.getYear()/100, D;

        if (m == 11 || m == 12)
            D = (this.year % 2) - 1;
        else
            D = this.year % 2;
        num = k + ((13*m-1)/5) + D + (D/4) + (C/4) - (2*C);
        num %= 7;
        if (num < 0)
            num += 7;
        return a[num];
    }

    // TASK 28
    public Boolean isMultiple(int num1, int num2) {
        if (num2 % num1 == 0)
            return true;
        return false;
    }

    // TASK 29
    public Boolean isLeapYear(DateClass d) {
        if (d.getYear() % 4 == 0 && d.getYear() % 100 != 0)
            return true;
        else if (d.getYear() % 4 == 0 && d.getYear() % 100 == 0 && d.getYear() % 400 == 0)
            return true;
        return false;
    }

    // TASK 30
    public DateClass earlierDate(DateClass d1, DateClass d2) {
        if (d1.isBefore(d2))
            return d1;
        else if (d1.isAfter(d2))
            return d2;
        else {
            System.out.println("The Dates are the same!");
            return new DateClass();
        }
    }

    // TASK 31
    public DateClass laterDate(DateClass d1, DateClass d2) {
        if (d1.isBefore(d2))
            return d2;
        else if (d1.isAfter(d2))
            return d1;
        else {
            System.out.println("The Dates are the same!");
            return new DateClass();
        }
    }

}
