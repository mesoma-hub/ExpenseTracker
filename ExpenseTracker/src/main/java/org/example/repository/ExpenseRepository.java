package org.example.repository;

import org.example.domain.Category;
import org.example.domain.Expense;

import java.time.Month;
import java.util.*;
import java.util.stream.IntStream;

public class ExpenseRepository {

    private final List<Expense> expenses = new ArrayList<>();
    private final Map<Month, Double> monthlyBudget = new HashMap<>();

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

    public void updateExpense(Expense expense) {
        int index = findExpenseIndexById(expense.getId());
        this.expenses.set(index, expense);
    }

    public void deleteExpenseById(int id) {
        this.expenses.removeIf(expense -> expense.getId() == id);
    }

    public Optional<Expense> findExpenseById(int id) {
        return this.expenses.stream()
                .filter(expense -> expense.getId() == id)
                .findFirst();
    }

    public int findExpenseIndexById(int id) {
        return IntStream.range(0, expenses.size())
                .filter(i -> expenses.get(i).getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Expense with ID " + id +
                        " not found"));
    }

    public void setMonthlyBudget(Month month, double budget) {
        monthlyBudget.put(month, budget);
    }

    public double getMonthlyBudget(Month month) {
        return monthlyBudget.getOrDefault(month, 0.0);
    }

    public List<Expense> getExpensesForMonth(Month month) {
        return expenses.stream()
                .filter(expense -> expense.getDate().getMonth().equals(month))
                .toList();
    }

    public List<Expense> getExpenseByCategory(Category category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equals(category))
                .toList();
    }
}
