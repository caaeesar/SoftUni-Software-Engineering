package Generics.exercises._01_GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> content;

    public Box() {
        this.content = new ArrayList<>();
    }

    public void add(T element) {
        this.content.add(element);
    }

   /* public void swap(int firstIndex, int secondIndex) {
        T swapVar = this.content.get(firstIndex);
        this.content.set(firstIndex, this.content.get(secondIndex));
        this.content.set(secondIndex, swapVar);
        //Collections.swap(content,firstIndex,secondIndex);
    }*/

    public long countGreaterElements(T element) {
        return content.stream().filter(e -> element.compareTo(e) < 0).count();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (T element : content) {
            output.append(element.getClass().getName());
            output.append(": ");
            output.append(element);
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
