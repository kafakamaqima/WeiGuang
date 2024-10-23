package com.niganma.demo;

public class test1 {

    public static void main(String[] args) {
        int half = 3;
        for (int i = 1; i <= half; i++) {//上半
            for (int j = 1; j <= half - i; j++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= 2 * i - 1; z++) {
                if (z == 1 || z == (2 * i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = half - 1; i >= 1; i--) {//下半
            for (int j = 1; j <= half - i; j++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= 2 * i - 1; z++) {
                if (z == 1 || z == (2 * i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
