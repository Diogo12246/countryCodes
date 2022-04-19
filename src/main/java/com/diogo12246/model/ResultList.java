package com.diogo12246.model;

import com.diogo12246.cc.CountryCodes;

import java.util.ArrayList;

public class ResultList {

    public void printResult(ArrayList<Country> list){
        for(Country c : list){
            System.out.println(c.getName() + ":" + c.getCellCount());
        }
    }


}
