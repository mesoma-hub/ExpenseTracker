package org.example;

import org.example.domain.Category;
import org.example.domain.Expense;
import org.example.domain.ExpenseTracker;
import org.example.domain.ExpenseUI;
import org.example.repository.ExpenseRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ExpenseRepository repository = new ExpenseRepository();
        ExpenseUI ui = new ExpenseUI();
        ExpenseTracker tracker = new ExpenseTracker(repository, ui);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Update Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Set Monthly Budget");
            System.out.println("6. Check Monthly Budget");
            System.out.println("7. Calculate Expense by Category");
            System.out.println("8. Read from a File");
            System.out.println("9. Exit");

            System.out.print("Choose an option: ");
            String choice = ui.askForInput();

            switch (choice) {
                case "1" -> tracker.add();
                case "2" -> tracker.update();
                case "3" -> tracker.delete();
                case "4" -> tracker.view();
                case "5" -> tracker.setMonthlyBudget();
                case "6" -> {
                    Month month = ui.askForMonth();
                    tracker.checkMonthlyBudget(month);
                }
                case "7" -> tracker.calculateExpensesByCategory();
                case "8" -> tracker.readFromFile();
                case "9" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

}