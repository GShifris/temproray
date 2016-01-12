package main.java.sort.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Gennady V. Shifris on 10.01.2016.
 */
public class Number {

    private Integer value;
    private Map<Integer, Integer> subcollection = new TreeMap<>();

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
