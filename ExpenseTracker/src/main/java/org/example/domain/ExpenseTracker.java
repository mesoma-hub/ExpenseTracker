package org.example.domain;

import org.example.repository.ExpenseRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class ExpenseTracker implements Addable, Deletable, Updateable, Viewable {
    public static final String PATH = "src/main/resources/expenses.csv";

    private final ExpenseRepository expenseRepository;
    private final ExpenseUI expenseUI;

    public ExpenseTracker(ExpenseRepository expenseRepository, ExpenseUI expenseUI) {
        this.expenseRepository = expenseRepository;
        this.expenseUI = expenseUI;
    }

    @Override
    public void add() {
        Expense expense = expenseUI.collectExpenseData();
        expenseRepository.addExpense(expense);
        System.out.println("Expense added: " + expense);
    }

    @Override
    public void update() {
        int id = expenseUI.askForExpenseId();
        Optional<Expense> optionalExpense = expenseRepository.findExpenseById(id);

        if (optionalExpense.isPresent()) {
            Expense updatedExpense = expenseUI.updateExpenseData(optionalExpense.get());
            expenseRepository.updateExpense(updatedExpense);
            System.out.println("Expense updated: " + updatedExpense);
        } else {
            System.out.println("Expense not found.");
        }
    }

    @Override
    public void delete() {
        int id = expenseUI.askForExpenseId();
        Optional<Expense> optionalExpense = expenseRepository.findExpenseById(id);

        if (optionalExpense.isPresent()) {
            expenseRepository.deleteExpenseById(id);
        }
    }

    public void setMonthlyBudget() {
        Month month = expenseUI.askForMonth();
        System.out.println("Enter the budget for " + month + ": ");
        double budget = Double.parseDouble(expenseUI.askForInput());
        expenseRepository.setMonthlyBudget(month, budget);
        System.out.println("Budget set for " +  month + ": $" + budget);
    }

    public List<Expense> getExpenseByCategory() {
       Category category = expenseUI.askForCategory();
       return expenseRepository.getExpenseByCategory(category);
    }
    public void checkMonthlyBudget(Month month) {
        double monthlyBudget = expenseRepository.getMonthlyBudget(month);
        List<Expense> monthlyExpenses = expenseRepository.getExpensesForMonth(month);

        double totalExpenses = monthlyExpenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        System.out.println("\n--- Budget Report for " + month + " ---");
        System.out.printf("Budget: $%,.2f%n", monthlyBudget);
        System.out.printf("Total Expenses: $%,.2f%n", totalExpenses);

        if (totalExpenses > monthlyBudget) {
            System.out.printf("Warning! you have exceeded the budget for %s by $%,.2f!%n",
                    month.toString(),
                    totalExpenses - monthlyBudget);
        } else {
            System.out.println("You're within the budget.");
        }
    }

    public void calculateExpensesByCategory() {
        Category category = expenseUI.askForCategory();
        List<Expense> categoryExpenses = expenseRepository.getExpenseByCategory(category);

        if (!categoryExpenses.isEmpty()) {
            double totalCategoryExpenses = categoryExpenses.stream()
                    .mapToDouble(Expense::getAmount)
                    .sum();
            System.out.println("\n--- Expense Report for " + category + " ---");
            System.out.printf("Total Expenses: $%,.2f%n", totalCategoryExpenses);
        } else {
            System.out.println("No expense for " + category + " Category");
        }
    }

    @Override
    public void view() {
        expenseUI.displayExpenses(expenseRepository.getAllExpenses());
    }

    public void readFromFile() {
        try {
            List<String> expensesLines =
                    Files.readAllLines(Path.of(PATH))
                            .stream()
                            .skip(1L)
                            .toList();

            for (String expenseLine : expensesLines) {
                String[] expenseArray = expenseLine.split(",");
                Expense expense = new Expense(Integer.parseInt(expenseArray[0]),
                        expenseArray[1],
                        Category.valueOf(expenseArray[2]), expenseArray[3],
                        Double.parseDouble(expenseArray[4]));
                expenseRepository.addExpense(expense);
            }
            System.out.println("Expenses read from file successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
