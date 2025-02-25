package org.example.patterns.iterator;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random = new Random();
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int next;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return next = random.nextInt(max - min + 1) + min;
            }
        };
    }
}
