package org.Excel;

public class Main {

    public static void main(String[] args) {
        SCVParser parser = new SCVParser();

        parser.inputData("C:\\Users\\Honor\\IdeaProjects\\Java lab 4 AA\\src\\main\\java\\org\\Excel\\foreign_names.csv");

        parser.print();
    }
}