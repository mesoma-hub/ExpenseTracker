package org.example.domain;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExpenseUI {
    private final Scanner scanner = new Scanner(System.in);

    public Expense collectExpenseData() {
        System.out.println("Enter expense description: ");
        String description = scanner.nextLine();

        System.out.println("Enter expense amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Category.printCategories();
        System.out.println("Enter expense category: ");
        Category category = Category.valueOf(scanner.nextLine().toUpperCase());

        return new Expense(description, amount, category);
    }

    public int askForExpenseId() {
        System.out.println("Enter the ID of the expense: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Expense updateExpenseData(Expense existingExpense) {
        System.out.println("Enter new description (current: " + existingExpense.getDescription() + "): ");
        String description = scanner.nextLine();

        System.out.println("Enter new amount (current: " + existingExpense.getAmount() + "): ");
        double amount = Double.parseDouble(scanner.nextLine());

        existingExpense.setDescription(description);
        existingExpense.setAmount(amount);
        existingExpense.setDate(LocalDate.now());

        return existingExpense;
    }

    public void displayExpenses(List<Expense> expenses) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.printf("%-6s %-15s %-15s %-10s %-15s%n", "ID", "Date", "Description", "Amount", "Category");
        System.out.println("----------------------------------------------------------------");
        expenses.forEach(expense -> System.out.printf(
                "%-6d %-15s %-15s %-10.2f %-15s%n",
                expense.getId(),
                expense.getDate(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getCategory()
        ));
    }

    public String askForInput() {
        return scanner.nextLine();
    }

    public Month askForMonth() {
        System.out.println("Enter a month number (i.e. 1 - 12) " + Arrays.toString(Month.values()));
        try {
            return Month.of(Integer.parseInt(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid month. Try again.");
            return askForMonth(); // Retry on invalid input
        }
    }

    public Category askForCategory() {
        System.out.println("Enter a Category (i.e. 1 - 7) " + Arrays.toString(Category.values()));
        try {
            return Category.of(Integer.parseInt(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Category. Try again.");
            return askForCategory(); // Retry on invalid input
        }
    }
}
