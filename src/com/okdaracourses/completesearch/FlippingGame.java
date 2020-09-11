package com.okdaracourses.completesearch;

import java.io.IOException;
import java.util.Scanner;

public class FlippingGame
{
    Scanner scanner;

    public static void main(String[] args) throws IOException
    {
        new FlippingGame().execute();
    }

    private void execute(){
        // initialize Scanner to read from command line
        scanner = new Scanner(System.in);
        // read length of the array
        int len = scanner.nextInt();
        // read values array
        int[] vals = readValues(len);
        solve(vals, len);
    }


    private int[] readValues(int len) {
        int[] vals = new int[len];
        for (int i = 0; i < len; ++i){
            vals[i] = scanner.nextInt();
        }
        return vals;
    }

    private void solve(int[] vals, int len) {
        int initialNumberOfOnes = countOnes(vals);
        int max = 0;
        for (int start = 0; start < len; ++start){
            for (int end = start; end < len; ++end){
                flip(start, end, vals);
                int currentNumberOfOnes = countOnes(vals);
                //print(vals, start, end);
                if (currentNumberOfOnes > max){
                    max = currentNumberOfOnes;
                }
                flip(start, end, vals);
            }
        }
        System.out.println(max);
    }

    private void flip(int start, int end, int[] vals) {
        for (int i = start; i <= end; ++i){
            vals[i] = 1 - vals[i];
        }
    }

    private void print(int[] vals, int start, int end){
        System.out.println("start = " + start + ", end = " + end);
        for (int val : vals){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    private int countOnes(int[] vals) {
        int count = 0;
        for (int val : vals){
            count += val;
        }
        return count;
    }

}
