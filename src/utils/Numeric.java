package utils;

import java.math.BigInteger;

public final class Numeric {

    static boolean isEven(int x) {
        // x is even?
        return ((x & 1) == 0);
    }

    static int multiplyByPowerOfTwo(int x, int exp) {
        // x * 2^exp
        return (x << exp);
    }

    static int divideByPowerOfTwo(int x, int exp) {
        // x / 2^exp
        return (x >> exp);
    }

    static int mostSignificantDigit(int x) {
        // most significant digit of x
        double k = Math.log10(x);
        k = k - Math.floor(k);
        return (int) Math.pow(10, k);
    }

    static int numberOfDigits(int x ) {
        // number of digits in x
        return (int) (Math.floor(Math.log10(x)) + 1);
    }

    static int greatestCommonDivisor(int x, int y) {
        // greatest common divisor of x and y
        return BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue();
    }

    static boolean isPrime(int x) {
        return BigInteger.valueOf(x).isProbablePrime(1);
    }

    static boolean isPowerOfTwo(int x) {
        // x is power of 2?
        return x != 0 && ((x & (x - 1)) == 0);
    }
}
