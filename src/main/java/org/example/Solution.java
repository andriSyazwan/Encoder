package org.example;

import java.util.Random;

public class Solution implements Encoder {
    private String charReference = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

    public String getCharReference(String pass) {
        if(pass.equals("ForTestOnly")) {
            return this.charReference;
        }

        return null;
    }

    @Override
    public String encode(String plainText) {
        return "";
    }

    @Override
    public String decode(String encodedText) {
        return "";
    }

    private int[] convertToNumArray(char[] charArray) {
        int[] result = new int[charArray.length];

        for(int i = 0; i < charArray.length; i++) {
            int currInt = charReference.indexOf(charArray[i]);
            result[i] = currInt == -1 ?  toUnicodeVal(charArray[i]) : currInt;
        }

        return result;
    }

    private char[] convertNumToCharArray(int[] numArr) {
        char[] result = new char[numArr.length];

        for(int i = 0; i < numArr.length; i++) {
            result[i] = numArr[i] < 0 ? toUnicodeChar(numArr[i]) : charReference.charAt(numArr[i]);
        }
        return result;
    }

    private int[] encodeNumArray(int[] numArray, int shift) {
        return numArray;
    }

    private int[] decodeNumArray(int[] numArray) {
        return numArray;
    }

    private int randomNumGen() {
        Random numGen = new Random();

        return numGen.nextInt(43) + 1;
    }

    private int toUnicodeVal(char c) {
        return - (int) c;
    }

    private char toUnicodeChar(int n) {
        return (char) -n;
    }

}
