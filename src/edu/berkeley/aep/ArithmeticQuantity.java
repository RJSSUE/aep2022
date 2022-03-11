package edu.berkeley.aep;

//compare and calculate metrics in different units
public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(Unit unit, Double value) {
        super(unit, value);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        // exception if not in the same category
        bombIfNotSameCategory(other);
        Unit type = Unit.INCH;
        if (unit.isSameCategory(Unit.TSP)) type = Unit.TSP;
        return new ArithmeticQuantity(type,convertToMinimumUnit()+other.convertToMinimumUnit());
    }
}
