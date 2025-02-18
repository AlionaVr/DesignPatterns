package org.example.patterns.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Logger logger = Logger.getLogger();


    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        logger.log("Starting program...");
        logger.log("Ask user to enter numbers");
        System.out.println("Hello! Enter size of list: ");
        int size = scanner.nextInt();
        checkNumber(size);
        System.out.println("Enter upper limit of number: ");
        int upperLimit = scanner.nextInt();
        checkNumber(upperLimit);

        List<Integer> numbers = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(upperLimit + 1));
        }
        System.out.println(numbers);

        System.out.println("Enter number for filter: ");
        int f = scanner.nextInt();
        checkNumber(f);

        Filter filter = new Filter(f);
        List<Integer> filteredNumbers = filter.filterOut(numbers);
        logger.log("Showing results: ...");
        System.out.println(filteredNumbers);
        logger.log("Finished program...");
    }

    private static void checkNumber(int input) {
        logger.log("Check number");
        if (input < 0) {
            System.out.println("Invalid input");
        }
    }
}
