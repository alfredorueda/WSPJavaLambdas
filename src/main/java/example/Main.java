package example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class Main {
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

        List<Transaction> transactionStream = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).toList();

        System.out.println(transactionStream);

        System.out.println("\nExercise 5.2 - What are all the unique cities where the traders work?\n");

        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().toList();

        System.out.println(cities);

        System.out.println("\nExercise 5.3 - Find all traders from Cambridge and sort them by name\n");

        List<Trader> trades = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equalsIgnoreCase("Cambridge"))
                        .sorted(Comparator.comparing(Trader::getName))
                        .distinct()
                        .toList();

        System.out.println(trades);

        System.out.println("\nExercise 5.4 - Return a string of all traders’ names sorted alphabetically\n");

        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println("names = " + names);

        System.out.println("\nExercise 5.5 - Are any traders based in Milan?\n");

        boolean tradesMilan = transactions.stream().anyMatch(trader -> trader.getTrader().getCity().equalsIgnoreCase("Milan"));

        System.out.println(tradesMilan);

        System.out.println("\nExercise 5.6 - Print all transactions’ values from the traders living in Cambridge\n");

        var stats = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .mapToInt(Transaction::getValue)
                .peek(value -> System.out.println("Value " + value))
                .summaryStatistics();

        System.out.println(stats);

        System.out.println("\nExercise 5.7 - What’s the highest value of all the transactions?\n");

        var maxvalue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max().orElse(0);

        System.out.println(maxvalue);

        System.out.println("\nExercise 5.8 - Find the transaction with the smallest value\n");

        var valueTransMin = transactions.stream()
                        .min(comparingInt(Transaction::getValue)).orElseThrow();

        System.out.println(valueTransMin);


    }
}