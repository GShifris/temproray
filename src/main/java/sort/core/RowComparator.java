package main.java.sort.core;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by GShifris on 1/8/2016.
 */
public class RowComparator implements Comparator<Double> {

    private Map<Double, Double> map;

    public RowComparator(Map<Double, Double> map) {
        this.map = map;
    }

    @Override
    public int compare(Double o1, Double o2) {

        if (map.get(o1).intValue() >= map.get(o2).intValue()) {
           return -1 ;
        } else {
            return 1;
        }

    }
}
