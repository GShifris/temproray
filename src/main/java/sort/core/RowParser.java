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
        wholeRow.setFirst(Double.parseDouble(numbers[0]));
        wholeRow.setSecond(Double.parseDouble(numbers[1]));
        wholeRow.setThird(Double.parseDouble(numbers[2]));
        wholeRow.setFourth(Double.parseDouble(numbers[3]));
        wholeRow.setFifth(Double.parseDouble(numbers[4]));
        wholeRow.setSixth(Double.parseDouble(numbers[5]));
        wholeRow.setSeventh(Double.parseDouble(numbers[6]));
        wholeRow.setEigth(Double.parseDouble(numbers[7]));
        return wholeRow;
    }

    public static List<Number> adaptToNumbers(String line) {
        String[] numbers = line.split(",");
        return null;
    }

}
