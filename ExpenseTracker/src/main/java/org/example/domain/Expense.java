package org.example.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Expense {
    private static int LAST_ID = 366;
    private int id;
    private String description;
    private LocalDate date;
    private double amount;
    private Category category;

    public Expense(String description,  double amount, Category category) {
        this.description = description;
        this.date = LocalDate.now();
        this.amount = amount;
        this.category = category;
        this.id = LAST_ID++;
    }

    public Category getCategory() {
        return category;
    }

    public Expense(int id, String date, Category category, String description, double amount) {
        this.description = description;
        this.date = LocalDate.parse(date);
        this.amount = amount;
        this.category = category;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return id == expense.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", category=" + category +
                '}';
    }
}
