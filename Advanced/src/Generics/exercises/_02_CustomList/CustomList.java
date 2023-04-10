package Generics.exercises._02_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void remove(int index) {
        this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.list,index1,index2);
    }

    public long countGreaterThan(T element) {
        return list.stream().filter(e -> element.compareTo(e) < 0).count();
    }

    public T getMax() {
       return Collections.max(this.list);
    }

    public T getMin() {
        return Collections.min(this.list);
    }

    public void sort() {
     this.list = this.list.stream().sorted().collect(Collectors.toList());
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public int size() {
        return this.list.size();
    }

    @Override
    public String toString() {
       StringBuilder output = new StringBuilder();
        for (T element : list) {
            output.append(element);
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
