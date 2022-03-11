package edu.berkeley.aep;

public class ScaledQuantity implements Bestable<ScaledQuantity> {
    protected final Unit unit;
    protected final Double value;

    public ScaledQuantity(Unit unit, Double value) {
        this.unit = unit;
        this.value = value;
    }

    public double convertToMinimumUnit() {
        return unit.convertToMinimumUnit(value);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        if (!unit.isSameCategory(((ScaledQuantity) other).unit)) return false;
        return convertToMinimumUnit() == ((ScaledQuantity) other).convertToMinimumUnit();
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToMinimumUnit());
    }

    @Override
    public boolean betterThan(ScaledQuantity other) {
        return convertToMinimumUnit() > other.convertToMinimumUnit();
    }

    void bombIfNotSameCategory(ScaledQuantity other) {
        if (!unit.isSameCategory(other.unit)) throw new RuntimeException("Cannot compare between different categories!");
    }
}
