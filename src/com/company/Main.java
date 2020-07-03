package com.company;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // TASK 23
	    DateClass firstTenThousand = new DateClass(1,1,2000);
	    int total = 1;
        System.out.println(firstTenThousand);
	    while (total != 10000) {
	        firstTenThousand = firstTenThousand.nextDate();
            System.out.println(firstTenThousand);
            total ++;
        }

        System.out.println("\n\n\n\n");

	    // TASK 24
        Calendar today = Calendar.getInstance();
        DateClass currentDate = new DateClass(today.get(Calendar.MONTH)+1, today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.YEAR));
        DateClass birthday = new DateClass(3,9,2001);
        DateClass dateToPrint = currentDate;
        while (!dateToPrint.isBefore(birthday)) {
            System.out.println(dateToPrint.dayOfTheWeek() + " " + dateToPrint);
            dateToPrint = dateToPrint.prevDate();
        }

        System.out.println("\n\n\n\n");

        // TASK 25
        dateToPrint = currentDate;
        while (!dateToPrint.isBefore(birthday)) {
            System.out.println(dateToPrint.dayOfTheWeek() + " " + dateToPrint);
            dateToPrint = dateToPrint.prevDate();
        }

        System.out.println("\n\n\n\n");

        // TASK 26
        DateClass start = new DateClass(1,1,0);
        DateClass end = new DateClass(12,31,9999);
        System.out.println(start.daysApart(end));

        System.out.println("\n\n\n\n");

        // TASK 27
        start = new DateClass(11,1,2018);
        end = new DateClass(11,30,2018);
        DateClass [] calendarNov = new DateClass[start.daysApart(end)+1];
        for (int i = 0; i < calendarNov.length; i++) {
            calendarNov[i] = start;
            start = start.nextDate();
        }
        String[] eventsNov = new String[calendarNov.length];
        for (int i = 0; i < eventsNov.length; i++) {
            eventsNov[i] = calendarNov[i].dayOfTheWeek();
            if (eventsNov[i].equals("Monday") || eventsNov[i].equals("Tuesday") || eventsNov[i].equals("Wednesday") || eventsNov[i].equals("Thursday") || eventsNov[i].equals("Friday"))
                eventsNov[i] = "Study for APCS";
            else
                eventsNov[i] = "R&R";
        }

        System.out.println("\n\n\n\n");

    }

}
