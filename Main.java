package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию с двумя целыми арабскими или римскими числами от 1 до 10 через пробел:");
        String str = scanner.nextLine();
        System.out.println(calc(str));
    }

    public static String calc(String input) throws Exception {
        String[] strSymb = input.split(" ");
        int sumArab;
        int sumRim;
        int symb1;
        int symb3;
        String sumRimFinal = null;
        String symb2 = strSymb[1];

        int length = strSymb.length;
        if (length != 3) {
            throw new Exception("Неправильная операция!");
        }

        symb1 = rim(strSymb[0]);
        symb3 = rim(strSymb[2]);

        if (symb1 == 0 && symb3 == 0) {
            symb1 = Integer.parseInt(strSymb[0]);
            symb3 = Integer.parseInt(strSymb[2]);
            if (symb1 <= 0 || symb1 > 10 || symb3 <= 0 || symb3 > 10) {
                throw new Exception("Числа должны быть от 1 до 10!");
            }
            switch (symb2) {
                case "+" -> sumArab = symb1 + symb3;
                case "-" -> sumArab = symb1 - symb3;
                case "*" -> sumArab = symb1 * symb3;
                case "/" -> sumArab = symb1 / symb3;
                default -> throw new Exception("Доступно только сложение, вычитание, умножение и деление. Вы что там пытаетесь сделать? :)");
            }
            return "Правильный ответ: " + sumArab;
        } else if (symb1 == 0 || symb3 == 0) {
            throw new Exception("Числа должны быть от 1 до 10, арабские либо римские одновременно");
        } else {
            switch (symb2) {
                case "+" -> sumRim = symb1 + symb3;
                case "-" -> sumRim = symb1 - symb3;
                case "*" -> sumRim = symb1 * symb3;
                case "/" -> sumRim = symb1 / symb3;
                default -> throw new Exception("Доступно только сложение, вычитание, умножение и деление. Вы что там пытаетесь сделать? :)");
            }
            if (sumRim <= 0) {
                throw new Exception("Результатом операции с римскими числами должно быть положительное число");
            } else {
                sumRimFinal = rimReturn(sumRim);
                return "Правильный ответ: " + sumRimFinal;
            }
        }
    }

    static int rim(String rimNumber) {
        return switch (rimNumber) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

    static String rimReturn(int returnRimNumber) {
        int ten = returnRimNumber / 10;
        int one = returnRimNumber % 10;
        String rimResult = "";
        switch (ten) {
            case 1 -> rimResult += "X";
            case 2 -> rimResult += "XX";
            case 3 -> rimResult += "XXX";
            case 4 -> rimResult += "XL";
            case 5 -> rimResult += "L";
            case 6 -> rimResult += "LX";
            case 7 -> rimResult += "LXX";
            case 8 -> rimResult += "LXXX";
            case 9 -> rimResult += "XC";
            case 10 -> rimResult += "C";
        }
        switch (one) {
            case 1 -> rimResult += "I";
            case 2 -> rimResult += "II";
            case 3 -> rimResult += "III";
            case 4 -> rimResult += "IV";
            case 5 -> rimResult += "V";
            case 6 -> rimResult += "VI";
            case 7 -> rimResult += "VII";
            case 8 -> rimResult += "VIII";
            case 9 -> rimResult += "IX";
        }
        return rimResult;
    }



}

