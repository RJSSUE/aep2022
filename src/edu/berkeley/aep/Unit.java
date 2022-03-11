package edu.berkeley.aep;

//understand and convert different units
public enum Unit {
    INCH(1,Category.LENGTH,0),
    FOOT(12,Category.LENGTH,0),
    YARD(12*3,Category.LENGTH,0),
    MILE(12*3*1760,Category.LENGTH,0),
    TSP(1,Category.VOLUME,0),
    TBSP(3,Category.VOLUME,0),
    OZ(3*2,Category.VOLUME,0),
    CUP(3*2*8,Category.VOLUME,0),
    FAH(1,Category.TEMPERATURE,0),
    CELSIUS(1.8,Category.TEMPERATURE,32);
    public enum Category{
        LENGTH,VOLUME,TEMPERATURE;
    }
    private double conversionRate;
    private double padding;
    private Category category;
    Unit(double rate, Category type, double y_intercept){
        conversionRate = rate;
        category = type;
        padding = y_intercept;
    }
    public double convertToMinimumUnit(double value){
        return value * conversionRate + padding;
    }
    public boolean isSameCategory(Unit other){
        return category == other.category;
    }
}
