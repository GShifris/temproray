package main.java.sort.core;


import main.java.sort.model.Row;

/**
 * Created by GShifris on 12/18/2015.
 */
public class RowParser {

    public static Row parse(String line) {

        String[] numbers = line.split(",");

        Row row = new Row();

        row.setFirst(Integer.parseInt(numbers[0]));
        row.setSecond(Integer.parseInt(numbers[1]));
        row.setThird(Integer.parseInt(numbers[2]));
        row.setFourth(Integer.parseInt(numbers[3]));
        row.setFifth(Integer.parseInt(numbers[4]));
        row.setSixth(Integer.parseInt(numbers[5]));
        row.setSeventh(Integer.parseInt(numbers[6]));
        row.setEigth(Integer.parseInt(numbers[7]));

        return row;
    }

}
