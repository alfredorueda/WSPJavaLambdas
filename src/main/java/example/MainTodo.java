package example;

import java.util.Arrays;
import java.util.List;

public class MainTodo {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("\nExercise 5.1 - Find all transactions in 2011 and sort by value (small to high)\n");


        System.out.println("\nExercise 5.2 - What are all the unique cities where the traders work?\n");


        System.out.println("\nExercise 5.3 - Find all traders from Cambridge and sort them by name\n");


        System.out.println("\nExercise 5.4 - Return a string of all traders’ names sorted alphabetically\n");


        System.out.println("\nExercise 5.5 - Are any traders based in Milan?\n");


        System.out.println("\nExercise 5.6 - Print all transactions’ values from the traders living in Cambridge\n");


        System.out.println("\nExercise 5.7 - What’s the highest value of all the transactions?\n");


        System.out.println("\nExercise 5.8 - Find the transaction with the smallest value\n");



    }
}