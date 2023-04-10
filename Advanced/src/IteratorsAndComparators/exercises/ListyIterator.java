package IteratorsAndComparators.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> list;
    private int index;

    public ListyIterator(String... args) {
        this.list = new ArrayList<>(Arrays.asList(args));
        index = 0;
    }

    public boolean move() {
        if (hasNext()){
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index + 1 < list.size();
    }

    public void print() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(this.list.get(index));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {

        private int innerIndex = 0;
        @Override
        public boolean hasNext() {
            return innerIndex < list.size();
        }

        @Override
        public String next() {
            if (hasNext()) {
                return list.get(innerIndex++);
            }
            return null;
        }
    }
}
