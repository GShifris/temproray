package main.java.sort.core;


import main.java.sort.model.WholeRow;
import main.java.sort.model.Number;

import java.util.List;

/**
 * Created by GShifris on 12/18/2015.
 */
public class RowParser {

    public static WholeRow parseWholeRow(String line) {

        String[] numbers = line.split(",");

        WholeRow wholeRow = new WholeRow();

        wholeRow.setFirst(Integer.parseInt(numbers[0]));
        wholeRow.setSecond(Integer.parseInt(numbers[1]));
        wholeRow.setThird(Integer.parseInt(numbers[2]));
        wholeRow.setFourth(Integer.parseInt(numbers[3]));
        wholeRow.setFifth(Integer.parseInt(numbers[4]));
        wholeRow.setSixth(Integer.parseInt(numbers[5]));
        wholeRow.setSeventh(Integer.parseInt(numbers[6]));
        wholeRow.setEigth(Integer.parseInt(numbers[7]));

        return wholeRow;
    }

    public static List<Number> adaptToNumbers(String line) {
        String[] numbers = line.split(",");

        return null;
    }

}
