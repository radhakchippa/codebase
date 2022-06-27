package com.rk.bitmanipulation;
//CCI - 5.1 question.
//Insert value of M in N from positions j to i.

/**
 * // check ranges on i and j since the question didn't mention anything about them.
 * // skip checking N and M as question states it is possible to put N in M.
 * Writeup:
 * Idea is to first mask the bits from position i to j inside N with 0 bits. -- create a Mask and do & operation
 * then create move the bits in M to their destination position i and j.
 * now do or operation on the M and the N to get the final result.
 * O(i-j)
 *
 *
 * */

public class Insertion {

    public static int replace(int N, int M, int i, int j) {
        //assume N has enough range, and i > j and m has (j-i number of bits)  N=10000000000 M=10011 i = 2, j=6
        int mask = 1;
        System.out.println(Integer.toBinaryString(N));
        for (int k = 0; k < (j - i); k++) { // k=3 mask =111100
            mask = (mask << 1) | 1;
        }
        mask = mask << i;
        N = N & (~mask); //10000000000 & 111100 = 10000000000
        M = M << i;  //      1001100
        N = N | M; //  10001001100
        return N;
    }

    public static void main(String[] args) {
        int a = ~23423;
        System.out.println("a:"+Integer.toBinaryString(a));
        int b = 5;
        System.out.println("b:"+Integer.toBinaryString(b));
        int c = replace(a, b, 29, 31);
        System.out.println("replaced positions i: 29, j: 31 in M \n"+Integer.toBinaryString(c));
    }
}
