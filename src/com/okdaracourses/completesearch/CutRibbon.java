package com.okdaracourses.completesearch;

import java.io.IOException;
import java.util.Scanner;

public class CutRibbon {
    private Scanner scanner;
    private static final int MAX = 4000;

    public static void main(String[] args) throws IOException
    {
        new CutRibbon().execute();
    }

    private void execute(){
        // initialize Scanner to read from command line
        scanner = new Scanner(System.in);
        // read length of the array
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        solveBruteForce(a, b, c, n);
    }


    private void solveBruteForce(int a, int b, int c, int target) {
        int max = 0;
        for (int x = 0; x <= MAX; ++x){
            for (int y = 0; y <= MAX; ++y){
                for (int z = 0; z <= MAX; ++z){
                    int sum = x * a + y * b + c * z;
                    int count = x + y + z;
                    if (sum == target && count > max){
                        max = count;
                    }
                }
            }
        }
        System.out.println(max);
    }

    private void solveOptimized(int a, int b, int c, int target) {
        int max = 0;
        for (int x = 0; x <= MAX; ++x){
            for (int y = 0; y <= MAX; ++y){
                int aAndBSum = (x * a + y * b);
                int zc = target - aAndBSum;
                if (zc < 0){
                    break;
                }
                if (zc % c == 0){
                    int count = x + y + (zc / c);
                    max = Math.max(count, max);
                }
            }
        }
        System.out.println(max);
    }

}
