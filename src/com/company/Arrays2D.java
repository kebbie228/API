package com.company;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays2D {
    public static void main(String[] args) {


    for(int[] a:fillOrder())
        System.out.println(Arrays.toString(a));
        for(int[] a:fillOrderTri())
            System.out.println(Arrays.toString(a));
        for(int[] a:fillOrderTri2())
            System.out.println(Arrays.toString(a));
        for(int[] a:fillOrderTri3())
            System.out.println(Arrays.toString(a));
  for(int[] a:fillOrderTri4())
            System.out.println(Arrays.toString(a));


    }
    //заполнить массив по порядку
     static int[][] fillOrder() {
       return IntStream.range(0, 3)
                .mapToObj(i -> IntStream.range(0, 3)
                        .map(j -> j + 1 + 3 * i)
                        .toArray())
                .toArray(int[][]::new);
    }
    /*
    //  1
    //	2 3
    //	4 5 6
    //	7 8 9 10
    //  11 12 13 14 15

     */
    static int[][] fillOrderTri() {
        AtomicInteger counter=new AtomicInteger(1);
        return IntStream.range(0, 5)
                .mapToObj(i -> IntStream.range(0, i+1)
                        .map(j ->counter.getAndIncrement())
                        .toArray())
                .toArray(int[][]::new);
    }

    /*
      1
      1 2
      1 2 3
      1 2 3 4
      1 2 3 4 5
     */
    static int[][] fillOrderTri2() {

        return IntStream.range(0, 5)
                .mapToObj(i -> IntStream.range(0, i+1)
                        .map(j ->j+1)
                        .toArray())
                .toArray(int[][]::new);
    }

    /*
      5 4 3 2 1
      5 4 3 2
      5 4 3
      5 4
      5
     */
    static int[][] fillOrderTri3() {

        return IntStream.range(0, 5)
                .mapToObj(i -> IntStream.range(0, 5-i)
                        .map(j ->5-j)
                        .toArray())
                .toArray(int[][]::new);
    }

    /*
      1
      1 2 1
      1 2 3 2 1
      1 2 3 4 3 2 1
     */
    static int[][] fillOrderTri4() {

        return IntStream.range(0, 5)
                .mapToObj(i-> Stream.iterate(new int[]{1,1},n->new int[]{n[0]+1,n[0]<i+1?n[1]+1:n[1]-1})
                        .limit(2*i+1)
                        .mapToInt(n->n[1])
                        .toArray())
                .toArray(int[][]::new);
    }
    /*
Простое число Мерсенна — это простое число, имеющее вид 2^P - 1.
Первыми простыми числами Мерсенна являются 3, 7, 31 и 127, соответствующие P = 2, 3, 5 и 7.
 */
}
