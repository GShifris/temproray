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

        List<WholeRow> wholeRows = readData();
        List<Map<Integer, Integer>> columns = RowUtils.getColumns(wholeRows);
        Set<Number> set = RowUtils.getValuesFromRow(wholeRows);

        columns.stream().forEach(System.out::println);
        set.stream().forEach(System.out::println);

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
