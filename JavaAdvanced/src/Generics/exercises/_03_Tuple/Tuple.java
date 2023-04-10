package Generics.exercises._03_Tuple;

public class Tuple <A,B>{
    private A item1;
    private B item2;

    public Tuple(A item1, B item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s",item1.toString(),item2.toString());
    }
}
