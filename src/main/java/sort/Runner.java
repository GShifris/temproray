package main.java.sort;

import main.java.sort.core.RowParser;
import main.java.sort.core.RowUtils;
import main.java.sort.model.WholeRow;

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

        List<WholeRow> wholeRows = readData();
        List<Map<Integer, Integer>> columns = getColumns(wholeRows);

        columns.stream().forEach(System.out::println);

    }



    private List<WholeRow> readData() {
        String fileName = "C:\\Users\\Gennady V. Shifris\\IdeaProjects\\temproray\\src\\main\\resources\\wholeRows.txt";
        List<WholeRow> wholeRows = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            return  stream.map(RowParser::parseWholeRow).collect(Collectors.toCollection(ArrayList::new));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return wholeRows;
    }

    private List<Map<Integer, Integer>> getColumns(List<WholeRow> wholeRows) {

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
}
