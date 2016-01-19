package main.java.sort.core;

import main.java.sort.model.WholeRow;
import main.java.sort.model.Number;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by GShifris on 1/8/2016.
 */
public class RowUtils {

    public static Map<Double, Double> sort(Map<Double, Double> map) {
        RowComparator comparator = new RowComparator(map);
        Map<Double, Double> result = new TreeMap<>(comparator);
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
            Double value2 = first.getSubcollection().get(row.getSecond());
            Double value3 = second.getSubcollection().get(row.getThird());
            Double value4 = third.getSubcollection().get(row.getFourth());
            Double value5 = fourth.getSubcollection().get(row.getFifth());
            Double value6 = fifth.getSubcollection().get(row.getSixth());
            first.getSubcollection().put(row.getSecond(), value2 == null ? 1L : value2 + 1);
            second.getSubcollection().put(row.getThird(), value3 == null ? 1L : value3 + 1);
            third.getSubcollection().put(row.getFourth(), value4 == null ? 1L : value4 + 1);
            fourth.getSubcollection().put(row.getFifth(), value5 == null ? 1L : value5 + 1);
            fifth.getSubcollection().put(row.getSixth(), value6 == null ? 1L : value6 + 1);
        }
        for (Number number : result) {
            number.setSubcollection(RowUtils.sort(number.getSubcollection()));
        }
        return result;
    }


    public static List<Map<Double, Double>> getColumns(List<WholeRow> wholeRows) {

        List<Map<Double, Double>> result = new LinkedList<>();
        Map<Double, Double> first = RowUtils.sort(wholeRows.stream()
                .collect(Collectors
                        .toMap( WholeRow::getFirst, p -> 1D, (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Double, Double> second = RowUtils.sort(wholeRows.stream()
                .collect(Collectors
                        .toMap(WholeRow::getSecond, p -> 1D, (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Double, Double> third = RowUtils.sort(wholeRows.stream()
                .collect(Collectors
                        .toMap(WholeRow::getThird, p -> 1D, (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Double, Double> fourth = RowUtils.sort(wholeRows.stream()
                .collect(Collectors
                        .toMap(WholeRow::getFourth, p -> 1D, (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Double, Double> fifth = RowUtils.sort(wholeRows.stream()
                .collect(Collectors
                        .toMap(WholeRow::getFifth, p -> 1D, (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Double, Double> sixth = RowUtils.sort(wholeRows.stream()
                .collect(Collectors
                        .toMap(WholeRow::getSixth, p -> 1D, (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Double, Double> seventh = RowUtils.sort(wholeRows.stream()
                .collect(Collectors
                        .toMap(WholeRow::getSeventh, p -> 1D, (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Double, Double> eight = RowUtils.sort(wholeRows.stream()
                .collect(Collectors
                        .toMap(WholeRow::getEigth, p -> 1D, (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
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

    public static Number getNumberFromCollection(Set<Number> setOfValues, Double value) {
        for (Number number : setOfValues) {
            if (number.getValue().intValue() == value.intValue()) {
                return number;
            }
        }
        Number result = new Number(value);
        setOfValues.add(result);
        return result;
    }


    public static List<Iterator<Double>> getIteratorsFromMap(List<WholeRow> wholeRows) {
        List<Iterator<Double>> result = new LinkedList<>();
        List<Map<Double, Double>> columns = getColumns(wholeRows);
        for (Map<Double, Double> column : columns) {
            result.add(column.keySet().iterator());
        }
        return result;
    }

    public static List<List<Double>> generateSimple(List<Iterator<Double>> iterators) {
        if (iterators.size() != 8) {
            throw new RuntimeException("Iterators are not presented");
        }
        List<List<Double>> result = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            List<Double> row = new LinkedList<>();
            for (Iterator<Double> iterator : iterators) {
                addNextValue(row, iterator);
            }
            result.add(row);
        }
        return result;
    }

    //TODO ?????????? ??? ??? ????? ?? 8-?? ????? (??????, ??????, ?????? ?? ?????? ? ?.?.).
    // ?????????????????? ????????, ?????? ?????? ????????? ??????
    //TODO ???????? ????? ? ????? ????????
    public static List<List<Double>> generate(Map<Double, Double> firstColumn, Set<Number> subCollections) {
        List<List<Double>> result = new ArrayList<>();
        int index = 0;
        for (Double value : firstColumn.keySet()) {
            if (index == 8) {
                continue;
            }
            List<Double> row = new LinkedList<>();
            row.add(value);
            while (row.size() < 8) {
                value = getNextValue(row, subCollections, value);
                row.add(value);
            }
            result.add(row);
            index++;
        }
        return result;

    }

    public static Double getNextValue(List<Double> row, Set<Number> subCollections, Double initialValue) {
        for (Number number : subCollections) {
            if (number.getValue().intValue() == initialValue.intValue()) {
                for (Double key : number.getSubcollection().keySet()) {
                    if (!row.contains(key)) {
                        return key;
                    }
                }
            }
        }
        return 0D;
    }

    public static void addNextValue(List<Double> result, Iterator<Double> iterator) {
        if (iterator.hasNext()) {
            Double value = iterator.next();
            while (result.contains(value)) {
                value = iterator.next();
            }
            result.add(value);
        }
    }

    public static Double compareTwoRows(List<Double> firstRow, WholeRow secondRow) {
        int result = 0;
        if (secondRow.getFirst().intValue() == firstRow.get(0)) {
            result++;
        }
        if (secondRow.getSecond().intValue() == firstRow.get(1)) {
            result++;
        }
        if (secondRow.getThird().intValue() == firstRow.get(2)) {
            result++;
        }
        if (secondRow.getFourth().intValue() == firstRow.get(3)) {
            result++;
        }
        if (secondRow.getFifth().intValue() == firstRow.get(4)) {
            result++;
        }
        if (secondRow.getSixth().intValue() == firstRow.get(5)) {
            result++;
        }
//        if (secondRow.getSeventh().intValue() == firstRow.get(6)) {
//            result++;
//        }
        if (firstRow.size() == 8 && secondRow.getEigth().intValue() == firstRow.get(7)) {
            result++;
        }
        return Double.valueOf(result);
    }
}
