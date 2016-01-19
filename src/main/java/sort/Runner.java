package main.java.sort;

import main.java.sort.core.RowParser;
import main.java.sort.core.RowUtils;
import main.java.sort.model.WholeRow;
import main.java.sort.model.Number;

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

//        List<WholeRow> wholeRows = readData();
//        List<Map<Double, Double>> columns = RowUtils.getColumns(wholeRows);
//        Set<Number> set = RowUtils.getValuesFromRow(wholeRows);
//
//        columns.stream().forEach(System.out::println);
//        set.stream().forEach(System.out::println);

        zero();
//        System.out.println("--///////////////////////////////////////////////////--");
//        first();
//        System.out.println("--///////////////////////////////////////////////////--");
//        second();

    }

    // http://umk.portal.kemsu.ru/uch-mathematics/papers/posobie/r4-3.htm
    private void zero() {

        List<WholeRow> wholeRows = readData();
        List<Map<Double, Double>> columns = RowUtils.getColumns(wholeRows);

        //probability
        for (Map<Double, Double> column : columns) {
            for (Map.Entry<Double, Double> value : column.entrySet()) {
                value.setValue(((double) wholeRows.size() / 100D) * value.getValue());
            }
        }

        columns.stream().forEach(System.out::println);

    }

    private void first() {

        List<WholeRow> wholeRows = readData();

        for (int i = 0; i < 50; i++) {
            WholeRow rowToCompare = wholeRows.get(i);

            List<WholeRow> rowsWithoutCurrentResult = new ArrayList<>(wholeRows.subList(i+1, wholeRows.size()));


            List<Iterator<Double>> iterators = RowUtils.getIteratorsFromMap(rowsWithoutCurrentResult);
            List<List<Double>> rows = RowUtils.generateSimple(iterators);

            List<Double> result = new LinkedList<>();

            for (List<Double> row : rows) {

                result.add(RowUtils.compareTwoRows(row, rowToCompare));
            }

            rows.stream().forEach(System.out::println);

            System.out.println(result);
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    private void second() {

        List<WholeRow> wholeRows = readData();

        for (int i = 0; i < 50; i++) {
            WholeRow rowToCompare = wholeRows.get(i);

            List<WholeRow> rowsWithoutCurrentResult = new ArrayList<>(wholeRows.subList(i+1, wholeRows.size()));
            List<Map<Double, Double>> columns = RowUtils.getColumns(rowsWithoutCurrentResult);
            Set<Number> subCollections = RowUtils.getValuesFromRow(rowsWithoutCurrentResult);

            List<List<Double>> rows = RowUtils.generate(columns.get(0), subCollections);

            List<Double> result = new LinkedList<>();

            for (List<Double> row : rows) {

                result.add(RowUtils.compareTwoRows(row, rowToCompare));
            }

//            rows.stream().forEach(System.out::println);

            System.out.println(result);
            System.out.println("--------------------------------------------------------------------------");
        }

    }

    private void third() {

    }

    private List<WholeRow> readData() {
        String fileName = "C:\\Users\\gshifris\\IdeaProjects\\Stat\\src\\main\\resources\\rows.txt";
        List<WholeRow> wholeRows = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            return  stream.map(RowParser::parseWholeRow).collect(Collectors.toCollection(ArrayList::new));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return wholeRows;
    }

}
