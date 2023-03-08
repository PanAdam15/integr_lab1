package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "katalog.txt";
        String noValue = "brak";
        File file = new File(fileName);
        HashMap<String, Integer> laptopCountMap = new HashMap<>();
        System.out.printf("%-2s %-14s %-14s %-14s %-14s %-14s %-14s %-14s %-14s %-14s %-14s %-14s %-29s %-14s %-30s %-14s ",
                " ", "Producent", "Przekatna", "Rozdzielczosc", "Powierzchnia", "Dotyk", "Nazwa Proc", "l. rdzeni", "Taktowanie", "RAM", "Poj. dysku",
                "Rodzaj dysku", "Grafika", "VRAM", "System", "Napęd");

        System.out.println();
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.useDelimiter(";");
            int rowNumber = 0;
            while (inputStream.hasNext()) {
                rowNumber++;
                String data = inputStream.nextLine();
                String[] values = data.split(";");
                System.out.printf("%-3s", rowNumber);
                int i = 0;
                for (String value : values) {
                    i++;
                    if (value.trim().isEmpty()) {
                        switch (i) {
                            case 12:
                            case 14:
                                System.out.printf("%-30s", noValue);
                                break;
                            default:
                                System.out.printf("%-15s", noValue);
                                break;
                        }
                    } else {
                        switch (i) {
                            case 12:
                            case 14:
                                System.out.printf("%-30s", value.trim());
                                break;
                            default:
                                System.out.printf("%-15s", value.trim());
                                break;
                        }
                    }

                }
                if (laptopCountMap.containsKey(values[0])) {
                    int count = laptopCountMap.get(values[0]);
                    laptopCountMap.put(values[0], count + 1);
                } else {
                    laptopCountMap.put(values[0], 1);
                }
                System.out.println();
            }
            System.out.println("\nLiczba laptopów każdego z producentów:");
            for (String manufacturer : laptopCountMap.keySet()) {
                System.out.println(manufacturer + ": " + laptopCountMap.get(manufacturer));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}