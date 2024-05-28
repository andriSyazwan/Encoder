package org.example;

import java.util.Random;

public class Solution implements Encoder {
    private char[] charReference = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '*',
            '+', ',', '-', '.', '/'
    };

    public char[] getCharReference(String pass) {
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

    private int[] ConvertToNumArray(char[] charArray) {
        int[] result = new int[charArray.length];
        return result;
    }

    private int[] encodeNumArray(int[] numArray, int shift) {
        return numArray;
    }

    private int[] decodeNumArray(int[] numArray, int shift) {
        return numArray;
    }

    private int randomNumGen() {
        Random numGen = new Random();

        return numGen.nextInt(44) + 1;
    }

}
