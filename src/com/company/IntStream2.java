package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class IntStream2 {
    //Последовательность чисел: 3, 33, 333, 3333, 33333, 333333 ...
    public static void main(String[] args) {
        System.out.println(Arrays.toString(gen33(6)));
        System.out.println(Arrays.toString(genFibonacchi(100)));
        System.out.println(Arrays.toString(gen10_1()));
        System.out.println(Arrays.toString(genPlus()));
        System.out.println(sum20());
        System.out.println(maxPrimeFactor(42));
    }

    public static int[] gen33(int count) {
        return IntStream.iterate(3, n -> n * 10 + 3)
                .limit(count)
                .toArray();
    }

    public static long[] genFibonacchi(long max) {
        return Stream.iterate(new long[]{0, 1}, a ->a[0]<max, a->new long[]{a[1], a[0] + a[1]})
                .mapToLong(a -> a[0])
                //.limit(10)
                .toArray();
    }
//Сгенерировать последовательность чисел: 10 1 9 2 8 3 7 4 6 5 5 6 4 7 3 8 2 9 1 10
public static int[] gen10_1() {
    return Stream.iterate(new int[]{10, 1}, a ->a[0]>0, a->new int[]{a[0]-1, a[1] +1})
            .flatMapToInt(IntStream::of)
            //.limit(10)
            .toArray();
}

    public static int[] genPlus() {
        return Stream.iterate(new int[]{1, 1}, a ->a[0]<30, a->new int[]{a[0]+a[1], ++a[1]})
            .mapToInt(a->a[0])
                .toArray();
    }

    public static int sum20() {
        //Первое число, сумма цифр которого равна 20 (или несколько первых таких чисел)
        return Stream.iterate(new int[]{1,1}, a->new int[]{++a[0],sum(Integer.toString(a[0]).chars().toArray())})
                .filter(a->a[1]==20)
                .mapToInt(a->a[0])
                .limit(1)
//.forEach(a-> System.out.println(a[0]));
                .findFirst().orElse(0);

    }

    static int sum(int[] arr){
        int result = 0;
        for (int a:arr) result+=a-'0';

//System.out.println(result);
        return result;
    }

    public static int[] genPrimes(int count) {
        //  Вывести n первых простых чисел
        return IntStream.iterate(1,n->n+1)
                .filter(n->isPrime(n))
                .limit(count)
                .toArray();
    }

    public static int maxPrimeFactor(int number) {
        //Максимальный простой делитель числа
        return IntStream.rangeClosed(2, number/2)
                .filter(n->number%n==0)
                .filter(n->isPrime(n))
                .max().getAsInt();
    }
    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

}

