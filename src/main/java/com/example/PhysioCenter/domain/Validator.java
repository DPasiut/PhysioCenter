package com.example.PhysioCenter.domain;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final int IDENTIFICATION_NUMBER_LENGTH = 11;
    private static final int[] IDENTIFICATION_NUMBER_WEIGHTS = { 1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1 };

    public static boolean isValidIdentificationNumber(String identificationNumber) {
        if (identificationNumber.length() != IDENTIFICATION_NUMBER_LENGTH) {
            return false;
        }

        List<Integer> numbers = convertStringToArrayOfIntegers(identificationNumber);
        int countedControlSum = countControlSum(numbers);

        return (countedControlSum % 10 == 0);
    }

    private static int countControlSum (List<Integer> identificationNumbers) {
        int controlSum = 0;
        int indexOfNumberWeight = 0;

        for (int number: identificationNumbers) {
            controlSum += number * IDENTIFICATION_NUMBER_WEIGHTS[indexOfNumberWeight++];
        }

        return controlSum;
    }

    private static ArrayList<Integer> convertStringToArrayOfIntegers (String inputData) {
        char[] inputDataChars = inputData.toCharArray();
        ArrayList<Integer> integers = new ArrayList<>();

        for (char character: inputDataChars) {
            integers.add((int) character);
        }

        return integers;
    }
}
