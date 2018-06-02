package com.mathematica.ds.paypal;

import java.util.*;

public class EvenLengthParlindrome_Solution {

    private static List<Map.Entry<Integer, Integer>> sortByFrequency(Map<Integer, Integer> unsortedMap){
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(unsortedMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> digit1, Map.Entry<Integer, Integer> digit2) {
                if(digit1.getValue().equals(digit2.getValue())){
                    return digit1.getKey().compareTo(digit2.getKey());

                }
                return digit2.getValue().compareTo(digit1.getValue());
            }
        });

     /*   Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
*/
        return list;
    }

    public static int getMaxRepetaionDigitX(Map<Integer, Integer> unsortedMap){
        List<Map.Entry<Integer, Integer>> list = sortByFrequency(unsortedMap);
        return list.get(0).getKey();
    }
    public static void main(String[] args) {
//        String evenLengthParlindrome = "1105223";
        String evenLengthParlindrome = "1100005223";
        HashMap<Integer, Integer> result = new HashMap<>(10);
        for (int i = 0; i < evenLengthParlindrome.length(); i++) {
            int digit = Character.getNumericValue(evenLengthParlindrome.charAt(i));
            if (result.containsKey(digit)) {
                result.put(digit, result.get(digit) + 1);
            } else {
                result.put(digit, 1);
            }
        }
//        Map<Integer, Integer> output = sortByFrequency(result);

        System.out.println(getMaxRepetaionDigitX(result));


    }
}
