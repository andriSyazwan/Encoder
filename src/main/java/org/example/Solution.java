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
        int shift = this.randomNumGen();
        String upperCased = plainText.toUpperCase();
        char[] charArrConverted = upperCased.toCharArray();
        int[] numArrConverted = this.convertToNumArray(charArrConverted);
        int[] encodedNumArr = this.encodeNumArray(numArrConverted, shift);
        char[] encodedCharArr = this.convertNumToCharArray(encodedNumArr);

        return new String(encodedCharArr);

    }

    @Override
    public String decode(String encodedText) {
        String upperCased = encodedText.toUpperCase();
        if(charReference.indexOf(upperCased.charAt(0)) == -1) {
            throw new InvalidFirstCharFound("The char " + encodedText.charAt(0) + " is not part of the table");
        }

        char[] charArrConverted = upperCased.toCharArray();
        int[] numArrConverted = this.convertToNumArray(charArrConverted);
        int[] decodedNumArr = this.decodeNumArray(numArrConverted);
        char[] decodedCharArr = this.convertNumToCharArray(decodedNumArr);

        return new String(decodedCharArr);
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
        int[] result = new int[numArray.length + 1];
        result[0] = shift;

        for(int i = 1; i < result.length; i++) {
            if(numArray[i - 1] < 0) {
                result[i] = numArray[i - 1];
                continue;
            }

            int encodedVal = numArray[i - 1] - shift;
            result[i] = encodedVal < 0 ? encodedVal + 44 : encodedVal;
        }
        return result;
    }

    private int[] decodeNumArray(int[] numArray) {
        int[] result = new int[numArray.length - 1];
        int shift = numArray[0];

        for(int i = 1; i < numArray.length; i++) {
            if(numArray[i] < 0) {
                result[i - 1] = numArray[i];
                continue;
            }

            int decodedVal = numArray[i] + shift;
            result[i - 1] = decodedVal > 43 ? decodedVal % 44 : decodedVal;
        }
        return result;
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
