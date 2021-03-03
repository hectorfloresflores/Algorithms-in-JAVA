package com.certification;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


class Euclean
{
    // extended Euclidean Algorithm
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }

    // A simple method to evaluate
    // Euler Totient Function
    static int phi(int n)
    {
        int result = 1;
        for (int i = 2; i < n; i++)
            if (gcd(i, n) == 1)
                result++;
        return result;
    }

}
// Code Contributed by Mohit Gupta_OMG <(0_o)>


public class EucleanExtended {

    @Override
    public String toString() {
        return super.toString();
    }

    public static BigInteger[] eucleanExtended(BigInteger power, BigInteger phi){

        BigInteger[] x = new BigInteger[2];
        BigInteger[] y = new BigInteger[2];
        BigInteger q, r, xx, yy, aa, bb;
        int sign;
        aa = power;
        bb = phi;

        x[0] = BigInteger.ONE;
        x[1] = BigInteger.ZERO;
        y[0] = BigInteger.ZERO;
        y[1] = BigInteger.ONE;
        sign = 1;

        while(!phi.equals(BigInteger.ZERO)) {
            r = power.mod(phi);
            q = power.divide(phi);

           System.out.println(power.toString() + " mod " + phi.toString());
            System.out.println(" ===> " + r + " = " + power + " - " + q + " * " + phi);
            System.out.println("\n");
            System.out.println("q: " + q);
            System.out.println("x: " + x[1]);
            System.out.println("y: " + y[1]);

            power = phi;
            phi = r;

            xx = x[1];
            yy = y[1];
            x[1] = q.multiply(x[1]).add(x[0]);
            y[1] = q.multiply(y[1]).add(y[0]);
            x[0] = xx;
            y[0] = yy;
            sign = -sign;
        }

        x[0] = x[0].multiply(new BigInteger(String.valueOf(sign)));
        y[0] = y[0].multiply(new BigInteger(String.valueOf(-sign)));

        System.out.println("x : " + x[0]);
        System.out.println("y : " + y[0]);

        System.out.println(power.toString() + " = " +
                x[0].toString() + " * " + aa.toString() + " + " +
                y[0].toString() + " * " + bb.toString());

        BigInteger[] coef = new BigInteger[3];
        coef[0] = power;
        coef[1] = x[0];
        coef[2] = y[0];

        return coef;
    }

    public static BigInteger[] encryptRSA(BigInteger p, BigInteger q, BigInteger e, BigInteger message) {
        BigInteger n = p.multiply(q);

        int hh = q.intValue() - 1;
        BigInteger phi = new BigInteger(String.valueOf((p.intValue()-1)*(q.intValue()-1)));


        BigInteger[] cypherAndKey = new BigInteger[2];
        cypherAndKey[0] = message.pow(e.intValue()).mod(n);
        cypherAndKey[1] = e.modInverse(phi);
        return cypherAndKey;
    }

    public static BigInteger decrypt(BigInteger privateKey, BigInteger cypherText, BigInteger n) {
        return cypherText.pow(privateKey.intValue()).mod(n);
    }

    public static void main(String[] args) throws ParseException {
        //EucleanExtended.eucleanExtended(new BigInteger("49"), new BigInteger("640"));

        /**
         * 1.-Using Euclidean algorithm, compute greatest common divisor of the following pairs of numbers:
         * 2091, 4807
         * 2475, 32670
         * 67942, 4209
         * 490256, 337
         */

        /*System.out.println("GCD of " + 2091 + " and " + 4807 + " is " + Euclean.gcd(2091, 4807));
        System.out.println("GCD of " + 2475 + " and " + 32670 + " is " + Euclean.gcd(2475, 32670));
        System.out.println("GCD of " + 67942 + " and " + 4209 + " is " + Euclean.gcd(67942, 4209));
        System.out.println("GCD of " + 490256 + " and " + 337 + " is " + Euclean.gcd(490256, 337));*/

        /**
         * 2.-Compute Euler’s phi function 𝞍 :
         * 20
         * 37
         * 503
         * 650
         * 809
         */

      /*  System.out.println("phi of " + 20 + " is " + Euclean.phi(20));
        System.out.println("phi of " + 37 + " is " + Euclean.phi(37));
        System.out.println("phi of " + 503 + " is " + Euclean.phi(503));
        System.out.println("phi of " + 650 + " is " + Euclean.phi(650));
        System.out.println("phi of " + 809 + " is " + Euclean.phi(809));*/

        /**
         * 3.-Compute multiplicative inverse of n modulus 𝞍:
         * n=7,𝞍 =20
         * n=11,𝞍=47
         * n=50,𝞍=231
         * n=100,𝞍=243
         */

       /* System.out.println("Compute multiplicative inverse of " + 7 + " modulus " + 20 + " is " +
                Arrays.toString(EucleanExtended.eucleanExtended(new BigInteger("7"), new BigInteger("20"))));
        System.out.println("Compute multiplicative inverse of " + 11 + " modulus " + 47 + " is " +
                Arrays.toString(EucleanExtended.eucleanExtended(new BigInteger("11"), new BigInteger("47"))));
        System.out.println("Compute multiplicative inverse of " + 50 + " modulus " + 231 + " is " +
                Arrays.toString(EucleanExtended.eucleanExtended(new BigInteger("50"), new BigInteger("231"))));
        System.out.println("Compute multiplicative inverse of " + 100 + " modulus " + 243 + " is " +
                Arrays.toString(EucleanExtended.eucleanExtended(new BigInteger("100"), new BigInteger("243"))));*/

        /**
         * 4.-Perform encryption and decryption using the RSA algorithm for the following:
         * p = 3; q = 11, e = 7; M = 5
         * p = 5; q = 11, e = 3; M = 9
         *  p = 7; q = 11, e = 17; M = 8
         *  p = 11; q = 13, e = 11; M = 7
         *  p = 17; q = 31, e = 7; M = 2
         */

/*        int [][] values = new int[][]{{3,11,7,5},{5,11,3,9},{7,11,17,8},{11,13,11,7},{17,31,7,2}};

        BigInteger[][] value1 = new BigInteger[values.length][];
        for (int i = 0; i< values.length; i++) {
            value1[i] = Arrays.stream(values[i])
                    .mapToObj(BigInteger::valueOf)
                    .toArray(BigInteger[]::new);
            BigInteger[] cypherAndKey1 = encryptRSA( value1[i][0],value1[i][1], value1[i][2], value1[i][3]);
            System.out.println("Message encrypted of " + value1[i][3] + " is " + cypherAndKey1[0] + " and private key is " + cypherAndKey1[1]);
            BigInteger decryptedMessage  = decrypt(cypherAndKey1[1], cypherAndKey1[0], value1[i][0].multiply(value1[i][1]));
            System.out.println("Message decrypted of " + cypherAndKey1[0] + " is " + decryptedMessage + " and private key is " + cypherAndKey1[1]);
        }

        int[] array = new int[]{31, 37, 17, 0};
        BigInteger[] arrays = Arrays.stream(array)
                .mapToObj(BigInteger::valueOf)
                .toArray(BigInteger[]::new);
        BigInteger[] d = encryptRSA(arrays[0], arrays[1], arrays[2], arrays[3]);
        System.out.println(d[1]);
        System.out.println("Message decrypted of " + 2 + " is " + decrypt(d[1], new BigInteger("2"), arrays[0].multiply(arrays[1])) + " and private key is " + 2);*/

        /*System.out.println(Euclean.phi(1080));*/

        System.out.println("Compute multiplicative inverse of " + 535 + " modulus " + 273 + " is " +
                Arrays.toString(EucleanExtended.eucleanExtended(new BigInteger("535"), new BigInteger("273"))));

        System.out.println(Euclean.gcd(535, 273));







    }
}
