package com.diogo12246.cc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UnparsedNumbers {
    private ArrayList<String> numbers;

    public UnparsedNumbers(String filename) {
        numbers = new ArrayList<>();
        File resourceFile = new File("./" + filename);
        try {
            Scanner sc = new Scanner(resourceFile);
            while (sc.hasNextLine()){
                String data = sc.nextLine();
                numbers.add(getNumber(data));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found, tried searching in the folder of the project " +
                    "the file '"+filename+"' and it was not found");
        }
    }

    private String getNumber(String data){
        // I could do this in the method above... but I rather have another method just in case requirements change.
        return data;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }
}
