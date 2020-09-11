package com.okdaracourses.binarysearch;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long start = 0;
        long end = x;

        while (start + 1 <= end) {
            long mid = (start + end) / 2;

            if ((mid + 1) * (mid + 1) > x && mid * mid <= x) {
                return (int) mid;
            }
            else if (mid * mid > x) {
                end = mid;
            }
            else if (mid * mid < x) {
                start = mid;
            }
        }

        return 0;
    }
}
