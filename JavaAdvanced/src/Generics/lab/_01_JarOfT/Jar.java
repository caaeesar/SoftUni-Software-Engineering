package Generics.lab._01_JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<T>();
    }

    public void add(T element) {
        this.stack.push(element);
    }

    /*public T remove() {
        return this.stack.pop();
    }*/
}
