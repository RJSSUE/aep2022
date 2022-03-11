package edu.berkeley.aep;

//understands the probability(likelihood) of something happening
public class Chance implements Bestable<Chance> {
    //internal state of the object is retained in fields
    private final double probability; //field
    //the code will not compile if you try to change the variable defined as "final"
    public Chance(double probability) {
        this.probability = probability;
        //use "this." to indicate it's the field; probability is a local variable
    }

    public Chance not() {
        return new Chance(1 - this.probability);
        //value object: the identity of the object comes from its value; primitive objects are value objects
        //for objects == compares their address, for primitive types it's the same as equals() method
    }

    public Chance and(Chance other) {
        return new Chance(probability*other.probability);
    }

    public Chance or(Chance other) {
        //a more object-oriented way of implementation: tell don't ask
        return this.not().and(other.not()).not();//calculate using DeMorgan's law
        //return new Chance(probability+other.probability-probability*other.probability);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        return Double.compare(((Chance) other).probability,probability) == 0;
        //double is a primitive type in Java, but Double is a class that has many functions that solve the problem of truncating and precision
    }

    //have to implement hashCode when overriding equals
    //the default hashCode uses the address in the memory
    //here: such that the objects that equal each other have the same hashcode
    //if we just return the same value for all objects, the map works inefficiently by executing equals() on each of these objects
    @Override
    public int hashCode(){
        return Double.hashCode(probability);
    }

    @Override
    public String toString() {
        return "Probability " + probability;
    }

    @Override
    public boolean betterThan(Chance other) {
        return probability > other.probability;
    }
}
