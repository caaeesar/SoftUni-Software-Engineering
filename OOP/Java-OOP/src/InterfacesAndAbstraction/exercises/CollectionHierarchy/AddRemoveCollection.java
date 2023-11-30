package InterfacesAndAbstraction.exercises.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {


    @Override
    public String remove() {
        String removedItem = super.items.get(this.items.size() - 1);
        super.items.remove(this.items.size() - 1);
        return removedItem;
    }

    @Override
    public int add(String item) {
        super.items.add(0,item);
        return 0;
    }
}
