package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {
    public static void main(String[] args) {
            String fileName = "katalog.txt";
            String noValue = "brak";
            File file = new File(fileName);
        System.out.printf("%-2s %-14s %-14s %-14s %-14s %-14s "," ","Producent","Przekatna","Rozdzielczosc","Powierzchnia","Dotyk");
        System.out.println();
            try {
                Scanner inputStream = new Scanner(file);
                inputStream.useDelimiter(";");
                int i = 0;
                while(inputStream.hasNext()) {
                    i++;
                    String data = inputStream.nextLine();
                    String[] values = data.split(";");
                    System.out.printf("%-3s", i );
                    for (String value : values) {
                        if(value.trim().isEmpty()){
                            System.out.printf("%-15s", noValue);
                        }else {
                            System.out.printf("%-15s", value.trim());
                        }
                        }
                    System.out.println();
                }
                inputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }