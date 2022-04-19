package com.diogo12246.app;

import com.diogo12246.cc.CountryCodes;
import com.diogo12246.cc.UnparsedNumbers;
import com.diogo12246.cc.utils.Filter;
import com.diogo12246.model.Country;
import com.diogo12246.model.ResultList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String filename = "";
        for(String s : args){
            if(s.contains(".txt")){
                filename = s;
            }
        }
        // create country list
        CountryCodes cc = new CountryCodes();

        // get all unparsed numbers
         UnparsedNumbers un = new UnparsedNumbers(filename);
        // UnparsedNumbers un = new UnparsedNumbers("input.txt");

        // Filter data
        Filter f = new Filter();
        ArrayList<Country> finalList = f.filteredCodes(cc, un);

        // print results
        ResultList rl = new ResultList();
        rl.printResult(finalList);
    }
}
