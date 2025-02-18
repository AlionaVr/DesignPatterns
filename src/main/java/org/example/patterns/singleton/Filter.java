package org.example.patterns.singleton;

import java.util.List;

public class Filter {
    private final int filterNumber;
    private final Logger logger = Logger.getLogger();

    protected Filter(int filterNumber) {
        this.filterNumber = filterNumber;
    }

    protected List<Integer> filterOut(List<Integer> numbers) {
        logger.log("Starting filter...");
        List<Integer> filtered = numbers.stream()
                .peek(num -> logger.log("Элемент \"" + num + "\" " + (num >= filterNumber ? "проходит" : "не проходит")))
                .filter(num -> num >= filterNumber).toList();
        logger.log("Finished filter...");
        return filtered;
    }
}
