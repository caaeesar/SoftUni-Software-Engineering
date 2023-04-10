package Workshop;

public class SmartArray<Integer> {
    private int[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;

    public SmartArray() {
       this.data = new int[INITIAL_CAPACITY];
       this.capacity = INITIAL_CAPACITY;
    }

    public int get(int index) {
        return this.data[index];
    }
    

    public boolean contains(int element) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == element){
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {

    }

}
