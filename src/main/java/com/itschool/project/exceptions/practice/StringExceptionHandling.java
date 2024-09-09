package com.itschool.project.exceptions.practice;

public class StringExceptionHandling {

    public static void main(String[] args) {
        String input = "Hello World";
        //              012345
        int validIndex = 2;
        int invalidIndex = 20;

        printChartAt(input, invalidIndex);

    }

    private static void printChartAt(String input, int index) {
        try {


            System.out.println("Character at index " + index + ":" + input.charAt(index));
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("StringIndexOutOfBoundsException: " + exception.getMessage());
        }
    }
}
