package com.mathematica.ds.transferwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solutions {

    static Map<Integer, String> arabicToRomanDictornary = new HashMap<Integer, String>();

    static {
        arabicToRomanDictornary.put(1, "I");
        arabicToRomanDictornary.put(2, "II");
        arabicToRomanDictornary.put(3, "III");
        arabicToRomanDictornary.put(4, "IV");
        arabicToRomanDictornary.put(5, "V");
        arabicToRomanDictornary.put(6, "VI");
        arabicToRomanDictornary.put(7, "VII");
        arabicToRomanDictornary.put(8, "VIII");
        arabicToRomanDictornary.put(9, "XI");
        arabicToRomanDictornary.put(10, "X");
        arabicToRomanDictornary.put(40, "XL");
        arabicToRomanDictornary.put(50, "L");
        arabicToRomanDictornary.put(90, "XC");
        arabicToRomanDictornary.put(100, "C");
        arabicToRomanDictornary.put(400, "CD");
        arabicToRomanDictornary.put(500, "D");
        arabicToRomanDictornary.put(900, "CM");
        arabicToRomanDictornary.put(1000, "M");
    }
    /*
     * Complete the 'romanizer' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static List<String> romanizer(List<Integer> numbers) {
        // Write your code here
        List<String> romanOutput = new ArrayList<>();
        for(Integer arabic : numbers){
            if(arabicToRomanDictornary.containsKey(arabic)){
                romanOutput.add(arabicToRomanDictornary.get(arabic));
            }else
            {
                String romanString = null;
                if(arabic <= 100){
                    int reminder = arabic%10;
                    int quotient = arabic/10;
                    if(reminder!=0){
                        romanString = arabicToRomanDictornary.get(reminder);
                    }
                    while(quotient!=0){
                        if(arabicToRomanDictornary.containsKey(quotient)){
                            romanString += arabicToRomanDictornary.get(quotient)+romanString;
                        }else{
                            quotient -= quotient;
                            romanString += arabicToRomanDictornary.get(10);
                        }
                    }
                    romanOutput.add(romanString);
                }else if(arabic <= 1000){
                    int reminder = arabic %100;
                    int quotient = arabic/100;
                    if(reminder!=0){
                        romanString = arabicToRomanDictornary.get(reminder);
                    }
                    while(quotient!=0){
                        if(arabicToRomanDictornary.containsKey(quotient)){
                            romanString += arabicToRomanDictornary.get(quotient)+romanString;
                        }else{
                            quotient -= quotient;
                            romanString += arabicToRomanDictornary.get(100);
                        }
                    }
                    romanOutput.add(romanString);
                }

            }
        }
       /* return numbers.stream().filter(arabicToRomanDictornary::containsKey)
                .map(arabicToRomanDictornary::get)
                .collect(Collectors.toList());*/
       return romanOutput;
    }

}
