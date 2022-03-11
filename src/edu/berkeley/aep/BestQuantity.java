package edu.berkeley.aep;

import java.util.Arrays;
import java.util.List;

// find the best quantity object
public final class BestQuantity {
    private final List<Bestable> listOfQuantities;

    public BestQuantity(Bestable... quantities) {
        listOfQuantities = Arrays.asList(quantities);
        if (listOfQuantities.contains(null)) throw new NullPointerException("List should not contain null!");
        if (listOfQuantities.isEmpty()) throw new ArrayIndexOutOfBoundsException("List should not be empty!");
    }

    public Bestable findMax() {
        var maxQuantity = listOfQuantities.get(0);
        for (var quantity : listOfQuantities) {
            if (quantity.betterThan(maxQuantity)) {
                maxQuantity = quantity;
            }
        }
        return maxQuantity;
    }
}
