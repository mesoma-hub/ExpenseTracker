
# Expense Tracker Application

The Expense Tracker is a Java-based console application designed to help users manage their daily expenses. It provides functionalities to add, update, delete, and view expenses while also offering tools to track spending against budgets and generate reports based on categories or months.

## Features

### Core Functionalities
- **Add Expenses**: Input details of your expenses, including the amount, category, and description.
- **View Expenses**: View all expenses or filter them by category or month.
- **Update Expenses**: Edit details of existing expenses.
- **Delete Expenses**: Remove unwanted or incorrect expense entries.

### Budget Management
- **Set Monthly Budget**: Set a budget for any month.
- **Budget Tracking**: Check if you're exceeding your budget with detailed reports.

### Reports
- **Category-Based Report**: View total spending for a specific category.
- **Monthly Budget Report**: Analyze your spending against the set monthly budget with warnings for budget overages.

### File Handling
- **CSV File Support**: Load expenses from a CSV file during application startup for easy initialization.

---

## Getting Started

### Prerequisites
- **Java**: Ensure you have Java 8 or above installed on your system.
- **IDE**: Use IntelliJ IDEA, Eclipse, or any Java-compatible IDE for development.

### Project Structure
```
src/
├── main/
│   ├── java/
│   │   ├── Expense.java          // Model class representing an expense
│   │   ├── ExpenseRepository.java // Repository for managing expenses
│   │   ├── ExpenseTracker.java    // Main class for expense tracking logic
│   │   ├── ExpenseUI.java         // Handles user input/output
│   │   ├── Addable.java           // Interface for add functionality
│   │   ├── Updateable.java        // Interface for update functionality
│   │   ├── Deletable.java         // Interface for delete functionality
│   │   └── Viewable.java          // Interface for view functionality
│   └── resources/
│       └── expenses.csv           // Sample data file
└── test/
    └── java/
        └── ExpenseTrackerTest.java // Unit tests
```

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/expense-tracker.git
   cd expense-tracker
   ```

2. Open the project in your IDE.

3. Compile and run the application:
   - Compile using your IDE or the command line:
     ```bash
     javac -d bin src/main/java/*.java
     ```
   - Run the application:
     ```bash
     java -cp bin ExpenseTracker
     ```

---

## How to Use

### 1. Load Initial Data
- Add a CSV file in the `src/main/resources/` directory named `expenses.csv`. The file format should be:
  ```
  ID,Description,Category,Date,Amount
  1,Groceries,FOOD,2025-01-01,50.0
  2,Electricity,UTILITIES,2025-01-05,75.0
  ```
- The application will load data from this file automatically at startup.

### 2. Manage Expenses
- Follow the menu prompts in the console to:
  - Add a new expense.
  - Update or delete an existing expense.
  - View all expenses or filter them by category/month.

### 3. Set and Monitor Budgets
- Set a budget for any month using the `Set Monthly Budget` option.
- Check your budget status through the `Check Monthly Budget` option.

### 4. Generate Reports
- View category-specific or monthly spending reports directly from the console.

---

## Example Usage

### Adding an Expense
```
Enter description: Dinner at a restaurant
Enter category (FOOD, TRAVEL, UTILITIES, etc.): FOOD
Enter date (YYYY-MM-DD): 2025-01-15
Enter amount: 45.99
Expense added: Expense{id=3, description='Dinner at a restaurant', category=FOOD, date=2025-01-15, amount=45.99}
```

### Setting a Budget
```
Enter the month (e.g., JANUARY, FEBRUARY): JANUARY
Enter the budget for JANUARY: 500.0
Budget set for JANUARY: $500.00
```

### Checking Monthly Budget
```
--- Budget Report for JANUARY ---
Budget: $500.00
Total Expenses: $120.00
You're within the budget.
```

### Generating a Category Report
```
Enter category (FOOD, TRAVEL, UTILITIES, etc.): FOOD
--- Expense Report for FOOD ---
Total Expenses: $145.99
```

---

## Dependencies
- **Java Standard Library**: No external dependencies are required.

---

## Future Enhancements
- Export expense data back to a CSV file for persistence.
- Add GUI support for better user interaction.
- Integrate advanced analytics (e.g., charts, trends).
- Implement authentication for multi-user support.

---

## Contributing

1. Fork the repository.
2. Create a new branch for your feature:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your feature description"
   ```
4. Push to your branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request.

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Contact
For questions or support, feel free to reach out:
- Email: anigbogumesoma1@gmail.com
- GitHub: [mesoma-hub](https://github.com/mesoma-hub)
