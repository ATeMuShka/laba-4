package org.Excel;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SCVParser {

    ArrayList<Human> rows;
    ArrayList<Division> divisions;

    private int findNameInDivisions(String name) {
        for (int i = 0; i < divisions.size(); i++)
            if (divisions.get(i).getName().equals(name))
                return i;
        return -1;
    }

    public SCVParser() {
        rows = new ArrayList<>();
        divisions = new ArrayList<>();
    }

    public void inputData(String csvFilePath) {
        int id;
        Date date;
        Division division;
        try {
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvFilePath)).withCSVParser(parser).build();

            List<String[]> data = csvReader.readAll();

            for (int i = 1; i < data.size(); i++) {
                date = new SimpleDateFormat("dd.MM.yyyy").parse(data.get(i)[3]);
                id = findNameInDivisions(data.get(i)[4]);
                if (id == -1) {
                    id = divisions.size();
                    division = new Division(id, data.get(i)[4]);
                    divisions.add(division);
                }
                else
                    division = new Division(id, data.get(i)[4]);
                rows.add(new Human(Integer.parseInt(data.get(i)[0]), data.get(i)[1], Gender.valueOf(data.get(i)[2]), date, division, Integer.parseInt(data.get(i)[5])));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print() {
        for (int i = 0; i < rows.size(); i++)
            rows.get(i).print();
    }
}
