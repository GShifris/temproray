package main.java.sort.core;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by GShifris on 1/8/2016.
 */
public class RowUtils {

    public static Map<Integer, Integer> sort(Map<Integer, Integer> map) {
        
        RowComparator comparator = new RowComparator(map);
        Map<Integer, Integer> result = new TreeMap<>(comparator);

        result.putAll(map);

        return result;
    }


}
