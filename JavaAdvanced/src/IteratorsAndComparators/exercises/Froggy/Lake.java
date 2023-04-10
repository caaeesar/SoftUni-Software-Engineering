package IteratorsAndComparators.exercises.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> elements;

    public Lake(List<Integer> elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Froggy();
    }

    private class Froggy implements Iterator<Integer> {
        int jumpIndex = 0;
        boolean isEnd = false;

        @Override
        public boolean hasNext() {
            return jumpIndex < elements.size();
        }

        @Override
        public Integer next() {
            int element = elements.get(jumpIndex);
            jumpIndex += 2;
            if (jumpIndex >= elements.size() && !isEnd) {
                jumpIndex = 1;
                isEnd = true;
            }
            return element;
        }
    }
}
