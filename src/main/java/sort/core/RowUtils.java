package main.java.sort.core;

import main.java.sort.model.WholeRow;
import main.java.sort.model.Number;

import java.util.*;
import java.util.stream.Collectors;

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

    public static Set<Number> getValuesFromRow(List<WholeRow> wholeRows) {

        Set<Number> result = new HashSet<>();

        for (WholeRow row : wholeRows) {

            Number first = getNumberFromCollection(result, row.getFirst());
            

            Number second = getNumberFromCollection(result, row.getSecond());
            Number third = getNumberFromCollection(result, row.getThird());
            Number fourth = getNumberFromCollection(result, row.getFourth());
            Number fifth = getNumberFromCollection(result, row.getFifth());
            Number sixth = getNumberFromCollection(result, row.getSixth());

            Integer value2 = first.getSubcollection().get(row.getSecond());
            Integer value3 = second.getSubcollection().get(row.getThird());
            Integer value4 = third.getSubcollection().get(row.getFourth());
            Integer value5 = fourth.getSubcollection().get(row.getFifth());
            Integer value6 = fifth.getSubcollection().get(row.getSixth());

            first.getSubcollection().put(row.getSecond(), value2 == null ? 1 : value2 + 1);
            second.getSubcollection().put(row.getThird(), value3 == null ? 1 : value3 + 1);
            third.getSubcollection().put(row.getFourth(), value4 == null ? 1 : value4 + 1);
            fourth.getSubcollection().put(row.getFifth(), value5 == null ? 1 : value5 + 1);
            fifth.getSubcollection().put(row.getSixth(), value6 == null ? 1 : value6 + 1);

        }

        for (Number number : result) {
            number.setSubcollection(RowUtils.sort(number.getSubcollection()));
        }

        return result;
    }


    public static List<Map<Integer, Integer>> getColumns(List<WholeRow> wholeRows) {

        List<Map<Integer, Integer>> result = new LinkedList<>();
        Map<Integer, Integer> first = RowUtils.sort(wholeRows.stream().
                collect(Collectors.toMap(WholeRow::getFirst, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> second = RowUtils.sort(wholeRows.stream()
                .collect(Collectors.toMap(WholeRow::getSecond, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> third = RowUtils.sort(wholeRows.stream()
                .collect(Collectors.toMap(WholeRow::getThird, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> fourth = RowUtils.sort(wholeRows.stream()
                .collect(Collectors.toMap(WholeRow::getFourth, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> fifth = RowUtils.sort(wholeRows.stream()
                .collect(Collectors.toMap(WholeRow::getFifth, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> sixth = RowUtils.sort(wholeRows.stream()
                .collect(Collectors.toMap(WholeRow::getSixth, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> seventh = RowUtils.sort(wholeRows.stream()
                .collect(Collectors.toMap(WholeRow::getSeventh, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> eight = RowUtils.sort(wholeRows.stream()
                .collect(Collectors.toMap(WholeRow::getEigth, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));

        result.add(first);
        result.add(second);
        result.add(third);
        result.add(fourth);
        result.add(fifth);
        result.add(sixth);
        result.add(seventh);
        result.add(eight);

        return result;
    }
    
    public static Number getNumberFromCollection(Set<Number> setOfValues, Integer value) {
        for (Number number : setOfValues) {
            if (number.getValue().intValue() == value.intValue()) {
                return number;
            }
        }

        Number result = new Number(value);

        setOfValues.add(result);

        return result;
    }
}
