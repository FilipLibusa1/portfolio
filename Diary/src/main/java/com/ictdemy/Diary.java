/************************************************/
/*                                              */
/*   ███████╗██╗██╗     ██╗██████╗              */
/*   ██╔════╝██║██║     ██║██╔══██╗             */
/*   █████╗  ██║██║     ██║██████╔╝             */
/*   ██╔══╝  ██║██║     ██║██╔═══╝              */
/*   ██║     ██║███████╗██║██║                  */
/*   ╚═╝     ╚═╝╚══════╝╚═╝╚═╝                  */
/*                                              */
/************************************************/

package com.ictdemy;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Diary {

    private Database database;
    private Scanner scanner = new Scanner(System.in);

    public Diary() {
        database = new Database();
    }
    private LocalDateTime readDateTime() {
        System.out.println("Enter date and time as [" + LocalDateTime.now().format(DATE_FORMAT) + "]:");
        while (true) {
            try {
                return LocalDateTime.parse(scanner.nextLine(), DATE_FORMAT);
            } catch (Exception ex) {
                System.out.println("Error. Please try again.");
            }
        }
    }

    private LocalDateTime readDate() {
        System.out.println("Enter date as [" + LocalDate.now().format(DATE_FORMAT_WITHOUT_TIME) + "]:");
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine(), DATE_FORMAT_WITHOUT_TIME).atStartOfDay();
            } catch (Exception ex) {
                System.out.println("Error. Please try again.");
            }
        }
    }
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d.M.y H:mm");
    public static final DateTimeFormatter DATE_FORMAT_WITHOUT_TIME = DateTimeFormatter.ofPattern("d.M.y");
    public void printEntries(LocalDateTime day) {
        ArrayList<Entry> entries = database.findEntries(day, false);
        for (Entry entry : entries) {
            System.out.println(entry);
        }
    }
    public void addEntry() {
        LocalDateTime dateTime = readDateTime();
        System.out.println("Enter the entry text:");
        String text = scanner.nextLine();
        database.addEntry(dateTime, text);
    }
    public void searchEntries() {

        LocalDateTime dateTime = readDate();

        ArrayList<Entry> entries = database.findEntries(dateTime, false);

        if (entries.size() > 0) {
            System.out.println("Entries found: ");
            for (Entry entry : entries) {
                System.out.println(entry);
            }
        } else {
            System.out.println("No entries were found.");
        }
    }
    public void deleteEntries() {
        System.out.println("Entries with the same exact date and time will be deleted");
        LocalDateTime dateTime = readDateTime();
        database.deleteEntries(dateTime);
    }
    public void printHomeScreen() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome to diary!");
        LocalDateTime today = LocalDateTime.now();
        System.out.printf("Today is: %s%n", DATE_FORMAT.format(today));
        System.out.println();
        // printing the home screen
        System.out.println("Today:\n-----");
        printEntries(today);
        System.out.println();
        System.out.println("Tomorrow:\n------");
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        printEntries(tomorrow);
        System.out.println();
    }

}