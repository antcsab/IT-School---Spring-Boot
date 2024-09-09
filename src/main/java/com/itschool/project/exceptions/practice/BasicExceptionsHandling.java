package com.itschool.project.exceptions.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicExceptionsHandling {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException exception) {
            System.out.println("Cannot divide by 0");
            System.out.println("Stack trace: " + exception.getStackTrace());
            System.out.println("Exception massage: " + exception.getMessage());
        } catch (InputMismatchException exception) {
            System.out.println("Please enter an integer ");

        }
    }
}
