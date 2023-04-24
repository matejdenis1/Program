package cz.uhk;

import cz.uhk.gui.MainFrame;
import cz.uhk.models.CsvFileOperations;
import cz.uhk.models.FileOperations;
import cz.uhk.models.JsonFileOperations;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");

        FileOperations io;
        //io = new JsonFileOperations();
        io = new CsvFileOperations();

        MainFrame frame = new MainFrame(800,600, io);
    }
}