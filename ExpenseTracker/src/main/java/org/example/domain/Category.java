package org.example.domain;

public enum Category {
    FOOD, HOUSING, TRANSPORTATION, ENTERTAINMENT, UTILITIES, HEALTHCARE, SHOPPING;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

    public static void printCategories() {
        System.out.print("The categories are: ");
        for (var i = 0; i < values().length - 1; i++) {
            System.out.printf("%s, ", values()[i]);
        }
        System.out.println(values()[values().length - 1]);
    }

    public static Category of(int index){
        return values()[index - 1];
    }
}
