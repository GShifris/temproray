package main.java.sort.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Gennady V. Shifris on 10.01.2016.
 */
public class Number implements Comparable<Number>{

    private Integer value;
    private Map<Integer, Integer> subcollection = new TreeMap<>();

    public Number(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Map<Integer, Integer> getSubcollection() {
        return subcollection;
    }

    public void setSubcollection(Map<Integer, Integer> subcollection) {
        this.subcollection = subcollection;
    }

    @Override
    public String toString() {
        return String.format("%02d", value) + " - " + getSubcollection().toString();
    }

    @Override
    public boolean equals(Object obj) {

        return obj instanceof Number && value.intValue() == ((Number) obj).getValue().intValue();
    }

    @Override
    public int compareTo(Number value2) {
        return value.compareTo(value2.getValue());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
