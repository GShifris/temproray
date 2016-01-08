package main.java.sort;

import main.java.sort.core.RowParser;
import main.java.sort.core.RowUtils;
import main.java.sort.model.Row;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by GShifris on 1/8/2016.
 */
public class Runner {

    public static void main(String[] args) {

        new Runner().run();

    }

    public void run() {

        List<Row> rows = readData();
        List<Map<Integer, Integer>> columns = getColumns(rows);

        columns.stream().forEach(System.out::println);

    }



    private List<Row> readData() {
        String fileName = "C://Users//gshifris//IdeaProjects//Stat//src//main//resources//rows.txt";
        List<Row> rows = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            return  stream.map(RowParser::parse).collect(Collectors.toCollection(ArrayList::new));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }

    private List<Map<Integer, Integer>> getColumns(List<Row> rows) {

        List<Map<Integer, Integer>> result = new LinkedList<>();
        Map<Integer, Integer> first = RowUtils.sort(rows.stream().
                collect(Collectors.toMap(Row::getFirst, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> second = RowUtils.sort(rows.stream()
                .collect(Collectors.toMap(Row::getSecond, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> third = RowUtils.sort(rows.stream()
                .collect(Collectors.toMap(Row::getThird, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> fourth = RowUtils.sort(rows.stream()
                .collect(Collectors.toMap(Row::getFourth, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> fifth = RowUtils.sort(rows.stream()
                .collect(Collectors.toMap(Row::getFifth, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> sixth = RowUtils.sort(rows.stream()
                .collect(Collectors.toMap(Row::getSixth, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> seventh = RowUtils.sort(rows.stream()
                .collect(Collectors.toMap(Row::getSeventh, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
        Map<Integer, Integer> eigth = RowUtils.sort(rows.stream()
                .collect(Collectors.toMap(Row::getEigth, p -> 1,
                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));

        result.add(first);
        result.add(second);
        result.add(third);
        result.add(fourth);
        result.add(fifth);
        result.add(sixth);
        result.add(seventh);
        result.add(eigth);

        return result;
    }


    //    private Map<Integer, Integer> rowsToColumn(List<Row> rows, Supplier<Integer> getElement) {
//
//        return RowUtils.sort(rows.stream()
//                .collect(Collectors.toMap(getElement, p -> 1,
//                        (oldValue, newValue) -> oldValue + newValue, TreeMap::new)));
//    }
}
