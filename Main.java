package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String input = "ABCDEFFghIABA";
        String[] inputStrings = {"daisy","pony","hellons","good"};
        getSubStrings(input);
        combineStrings(inputStrings);

    }

    /**
     * Get incremental substrings from string
     * @param input
     */
    public static void getSubStrings(String input){
        List<String> substringList = new ArrayList<>();
        int j=0;

        for(int i=0;i<input.length()-1;i++){
            if (input.charAt(i) >= input.charAt(i + 1) || Character.isLowerCase(input.charAt(i)) == Character.isUpperCase(input.charAt(i+1)) ||
                    Character.isUpperCase(input.charAt(i)) == Character.isLowerCase(input.charAt(i+1))) {
                substringList.add(input.substring(j, i + 1));
                j = i + 1;
            }

        }
        substringList.add(input.substring(j));
        String[] solution = substringList.toArray(new String[substringList.size()]);
        for (String str:solution) {
            System.out.println(str);
        }
    }

    /**
     * Function to combine String based on their index
     * @param inputStrings
     */
    public static void combineStrings(String[] inputStrings){
        StringBuilder stringBuilder = new StringBuilder();
        String longest = Arrays.stream(inputStrings).max(Comparator.comparingInt(String::length)).get();
        for (int i=0;i<longest.length();i++){
            for(int j=0;j<inputStrings.length;j++){
                String str = inputStrings[j];
                if(i < str.length()) {
                    stringBuilder.append(str.charAt(i));
                }
            }
        }
        System.out.println(stringBuilder);
    }

}
