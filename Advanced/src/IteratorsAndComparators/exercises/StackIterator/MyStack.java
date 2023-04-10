package IteratorsAndComparators.exercises.StackIterator;

import java.util.*;

public class MyStack<Integer> implements Iterable<Integer> {
    private List<Integer> stack = new ArrayList<>();

    public void push(List<Integer> elements) {
        stack.addAll(elements);
    }

    public int pop() { //todo
        try {
            stack.remove(stack.size() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) stack.get(stack.size() - 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }


    private class StackIterator implements Iterator<Integer> {
        boolean isEnd = false;
        int index = stack.size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            Integer element = stack.get(index);
            index -= 1;
            if (index < 0 && !isEnd) {
                index = stack.size() - 1;
                isEnd = true;
            }
            return element;
        }
    }

}