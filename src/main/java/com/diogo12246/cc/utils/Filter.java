package com.diogo12246.cc.utils;

import com.diogo12246.cc.CountryCodes;
import com.diogo12246.cc.UnparsedNumbers;
import com.diogo12246.model.Country;

import java.util.ArrayList;

public class Filter {
    private ArrayList<Country> countriesWithNumbers;
    private ArrayList<Character> invalidChars;

    public Filter() {

        invalidChars = new ArrayList<>();

        Character char1 = '/';
        Character char2 = '*';
        Character char3 = '-';
        Character char4 = ')';
        Character char5 = '(';
        Character char6 = '#';
        Character char7 = '$';

        invalidChars.add(char1);
        invalidChars.add(char2);
        invalidChars.add(char3);
        invalidChars.add(char4);
        invalidChars.add(char5);
        invalidChars.add(char6);
        invalidChars.add(char7);

    }

    public ArrayList<Country> filteredCodes(CountryCodes cc, UnparsedNumbers un){
        countriesWithNumbers = new ArrayList<>();
        for (String number : un.getNumbers()){
            boolean valid = true;

            if(isShort(number)){
                    if(hasWhiteSpaces(number)){
                        valid = false;
                    } else {
                        if(hasInvalidStart(number)){
                            valid = false;
                        } else {
                            if(hasInvalidChars(number)){
                                valid = false;
                            } else {
                                cc.addCellCountToCountry("Portugal");
                            }
                        }
                    }

            }

            if(isLong(number)){
                String code = "";
                if(number.startsWith("+")){
                    code = number.substring(0,4);
                    code = code.trim();
                }

            // Now comes the hard part, I know "00" is a international number prefix
            // This exercise could be better detailed in the readme.md about the 00 (I dont know what to do here or
            // what countries we must code the "00" to...)
            // Since it is not explicit I will treat 00 as nothing and count the 2 digits after.
            // So please have patience because the results might be wrong.
                if(number.startsWith("00")){
                    code = number.substring(0,4); // I don't know if it is to count 2 or 3 digits, if 3, change to (0,5)
                    // I went with (0,4) because Australia IDD prefix is "0011" so it makes sense only 2 digits.
                    code = code.trim();
                    code = code.replace("00","+");
                }

                for(Country c : cc.getCountryList()){
                    if(c.getCode().equalsIgnoreCase(code)){
                        cc.addCellCountToCountryByCode(code);
                    }
                }
            }
        }
        for(Country c : cc.getCountryList()){
            if(c.getCellCount()>0){
                countriesWithNumbers.add(c);
            }
        }
        return countriesWithNumbers;
    }

    private boolean hasInvalidChars(String number) {
        boolean invalid = false;
        for(Character c : invalidChars){
            if (number.contains(String.valueOf(c))){
                invalid = true;
                break;
            }
        }
        return invalid;
    }

    private boolean hasInvalidStart(String number){
            if (number.startsWith("0")){
                return true;
            } else return false;
    }

    private boolean hasInvalidStartAndLengthLong(String number){
        boolean invalid = false;

        if (number.startsWith("+")){
            if(number.startsWith("+ ")){
                invalid = true;
            } else {
                int length;
                length = number.replace("+","").length();
                length = number.replaceAll(" ","").length();
                if(length >= 14){
                    invalid = true;
                }
            }
        }
        if(number.startsWith("00")){
            if (number.startsWith("00 ")){
                invalid = true;
            } else {
                int length;
                length = number.replace("00","").length();
                length = number.replaceAll(" ","").length();
                if(length >= 14){
                    invalid = true;
                }
            }
        }
        return invalid;
    }

    private boolean hasWhiteSpaces(String number){
        if(number.contains(" ")){
            return true;
        } else return false;
    }

    private boolean isShort(String number){
        int length = number.length();
        if(length>= 4 && length<=6){
            return true;
        }
        else return false;
    }

    private boolean isLong(String number){
        int length = number.length();
        if(length>= 9){
            if(hasInvalidStartAndLengthLong(number)){
                return false;
            } else {
                return true;
            }
        }
        else return false;
    }
}
