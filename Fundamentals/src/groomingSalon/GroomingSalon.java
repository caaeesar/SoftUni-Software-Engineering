package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;


   public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) { // if there is an empty place
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        int index = findPetIndex(name);

        if (index != -1) { // therefore, the pet exist and remove
            this.data.remove(index);
            return true;
        }
        return false; // the pet doesn't exist
    }

    public int findPetIndex(String name) {
        for (int petIndex = 0; petIndex < data.size(); petIndex++) {
            Pet currentPet = data.get(petIndex);
            if (currentPet.getName().equals(name)) {
                return petIndex;
            }
        }
        return -1;
    }

    public Pet getPet(String name, String owner) {
        for (int petIndex = 0; petIndex < data.size(); petIndex++) {
            Pet currentPet = data.get(petIndex);
            if (currentPet.getName().equals(name) && currentPet.getOwner().equals(owner)) {
                return currentPet;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder statisticsFormat = new StringBuilder();
        statisticsFormat.append("The grooming salon has the following clients:");
        statisticsFormat.append(System.lineSeparator());
        for (Pet currentPet : data) {
            statisticsFormat.append(currentPet.getName());
            statisticsFormat.append(" ");
            statisticsFormat.append(currentPet.getOwner());
            statisticsFormat.append(System.lineSeparator());
        }
        return statisticsFormat.toString();
    }
}
