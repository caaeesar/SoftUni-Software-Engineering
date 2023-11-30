package WorkingWithAbstraction.exercises.greedyTimes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class Bag {
    private final long capacity;
    private long currentWeight;

    Map<String, Long> itemsTotalQuantity;

    private long gold;
    private Map<String, Long> gems;
    private Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.itemsTotalQuantity = new HashMap<>();
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
    }

    public void addCash(String item, long quantity) {
        if (isHaveFreeSpace(quantity) && getTotalGems() >= getTotalCash() + quantity) {
            this.currentWeight += quantity;

            Long currentQuantity = this.cash.get(item);
            if (currentQuantity == null) {
                currentQuantity = 0L;
            }
            this.cash.put(item, currentQuantity + quantity);
        }
    }

    public void addGems(String item, long quantity) {
        if (isHaveFreeSpace(quantity) && getTotalGold() >= getTotalGems() + quantity) {

            this.currentWeight += quantity;

            Long currentQuantity = this.gems.get(item);
            if (currentQuantity == null) {
                currentQuantity = 0L;
            }
            this.gems.put(item, currentQuantity + quantity);
        }
    }

    public void addGold(long quantity) {
        if (isHaveFreeSpace(quantity)) {
            this.gold += quantity;
            this.currentWeight += quantity;
        }
    }

    private boolean isHaveFreeSpace(long quantity) {
        return this.currentWeight + quantity <= this.capacity;
    }

    private long getTotalGems() {
        return this.gems.values().stream().mapToLong(e -> e).sum();
    }

    private long getTotalCash() {
        return this.cash.values().stream().mapToLong(e -> e).sum();
    }

    public long getTotalGold() {
        return gold;
    }

    public void showBagContent() {

        System.out.printf("<Gold> $%d\n", getTotalGold());
        System.out.printf("##Gold - %d\n", getTotalGold());

        if (!this.gems.isEmpty()) {
            System.out.printf("<Gem> $%d\n", getTotalGems());
            this.gems.entrySet().stream().sorted((g1, g2) -> {
                int result = g2.getKey().compareTo(g1.getKey());
                if (result == 0) {
                    result = g1.getValue().compareTo(g2.getValue());
                }
                return result;
            }).forEach(gem -> System.out.printf("##%s - %d\n", gem.getKey(), gem.getValue()));
        }

        if (!this.cash.isEmpty()) {
            System.out.printf("<Cash> $%d\n", getTotalCash());
            this.cash.entrySet().stream().sorted((c1, c2) -> {
                int result = c2.getKey().compareTo(c1.getKey());
                if (result == 0) {
                    result = c1.getValue().compareTo(c2.getValue());
                }
                return result;
            }).forEach(c -> System.out.printf("##%s - %d\n", c.getKey(), c.getValue()));
        }

       /* this.itemsTotalQuantity.put("Gold", getTotalGold());
        this.itemsTotalQuantity.put("Gem", getTotalGems());
        this.itemsTotalQuantity.put("Cash", getTotalCash());

        this.itemsTotalQuantity.entrySet().stream().filter(i -> i.getValue() != 0L).sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .forEach(item -> {
                    System.out.printf("<%s> $%d\n", item.getKey(), item.getValue());

                    switch (item.getKey()) {

                        case "Gold":
                            System.out.printf("##Gold - %d\n", getTotalGold());
                            break;

                        case "Cash":
                            this.cash.entrySet().stream().sorted((c1, c2) -> {
                                int result = c2.getKey().compareTo(c1.getKey());
                                if (result == 0) {
                                    result = c1.getValue().compareTo(c2.getValue());
                                }
                                return result;
                            }).forEach(c -> System.out.printf("##%s - %d\n", c.getKey(), c.getValue()));
                            break;

                        case "Gem":
                            this.gems.entrySet().stream().sorted((g1, g2) -> {
                                int result = g2.getKey().compareTo(g1.getKey());
                                if (result == 0) {
                                    result = g1.getValue().compareTo(g2.getValue());
                                }
                                return result;
                            }).forEach(gem -> System.out.printf("##%s - %d\n", gem.getKey(), gem.getValue()));
                            break;
                    }
                });*/
    }
}
