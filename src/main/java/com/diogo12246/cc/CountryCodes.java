package com.diogo12246.cc;

import com.diogo12246.model.Country;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryCodes {

    private ArrayList<Country> countryList;
    private ArrayList<Country> filteredList;

    public CountryCodes() {
        filteredList = new ArrayList<>();
        countryList = new ArrayList<>();
        File resourceFile = new File("./countryCodes.txt");
        try {
            Scanner sc = new Scanner(resourceFile);
            while (sc.hasNextLine()){
                String data = sc.nextLine();
                countryList.add(countryParser(data));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found, tried searching in the folder of the project " +
            "the file 'countryCodes' and it was not found");
        }
    }

    private Country countryParser(String unparsedCountry){
        Country country = new Country();
        String[] parsedComponents = unparsedCountry.split("-");
        country.setName(parsedComponents[0]);
        country.setCode("+"+parsedComponents[1]);
        return country;
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public Country getCountryByCode(String code){
        for(Country c : countryList){
            if(c.getCode().equals(code)){
                return c;
            }
        }
        return null;
    }

    public Country getCountryByName(String name){
        for(Country c : countryList){
            if(c.getCode().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }

    public void addCellCountToCountry(String name){
        int index = 0;
        for(Country c : countryList){
            index++;
            if(c.getName().equalsIgnoreCase(name)){
                int count = countryList.get(index-1).getCellCount();
                countryList.get(index-1).setCellCount(count+1);
                break;
            }
        }
    }

    public void addCellCountToCountryByCode(String code){
        int index = 0;
        for(Country c : countryList){
            index++;
            if(c.getCode().equalsIgnoreCase(code)){
                int count = countryList.get(index-1).getCellCount();
                countryList.get(index-1).setCellCount(count+1);
                break;
            }
        }
    }

    public ArrayList<Country> getFilteredList() {
        return filteredList;
    }

}
