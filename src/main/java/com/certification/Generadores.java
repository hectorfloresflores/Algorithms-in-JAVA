package com.certification;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Person {

    public BigInteger[] getMayusAndMinus(long p, long alpha) {
        BigInteger gen = Generadores.run(new BigInteger(String.valueOf(p)));

        BigInteger alphaBig = new BigInteger(String.valueOf(alpha));
        BigInteger AorB = alphaBig.modPow(gen, new BigInteger(String.valueOf(p)));
        return new BigInteger[]{AorB, gen};
    }

    public BigInteger[] getMayusAndMinus(long p, long alpha, long gen1) {
        BigInteger gen = new BigInteger(String.valueOf(gen1));

        BigInteger alphaBig = new BigInteger(String.valueOf(alpha));
        BigInteger AorB = alphaBig.modPow(gen, new BigInteger(String.valueOf(p)));
        return new BigInteger[]{AorB, gen};
    }

    public BigInteger decifrar(long BorA, long aOrb, long p) {
        BigInteger AOrBBig = new BigInteger(String.valueOf(BorA));
        BigInteger AorB = AOrBBig.modPow(new BigInteger(String.valueOf(aOrb)), new BigInteger(String.valueOf(p)));
        return AorB;
    }

}

public class Generadores {

    public static BigInteger run(BigInteger p) {
       BigInteger first = null;
       boolean flag = false;
        long exp, counter = 0, value = 0;
        BigInteger A;
        for (long i = 2; i < p.longValue()-1; i++) {
            exp = i;
            BigInteger I = new BigInteger(String.valueOf(i));
            A = new BigInteger(String.valueOf(i));
            counter= 1;

            while (A.longValue() != 1 && counter < p.longValue()) {

                A = A.multiply(I).mod(p);
                counter++;
            }

            if (counter == p.longValue() - 1) {
                if (!flag)
                    first = new BigInteger(String.valueOf(i));
                flag = true;
                System.out.println(i);
                value++;
            }

        }


        System.out.println("Generadores en total: " + value);
        return first;
    }

    public static void run1(long p) {

        long exp, counter = 0, value = 0;
        long A;
        for (long i = 2; i < p-1; i++) {
            exp = i;
            //BigInteger I = new BigInteger(String.valueOf(i));
            A = i;
            counter= 1;

            while (A != 1 && counter < p) {

                A = Mod.mod(A*exp, p);
                //A = A.multiply(I).mod(p);
                counter++;
            }

            if (counter == p - 1) {

                System.out.println(i);
                value++;
            }

        }


        System.out.println("Generadores en total: " + value);

    }

    public static void main(String[] args) {
     /*   long p = 73, alpha = 47;
        Person cliente = new Person();
        BigInteger[] mayusAndMinus = cliente.getMayusAndMinus(p, alpha);


        Person bob = new Person();
        BigInteger[] mayusAndMinus1 = bob.getMayusAndMinus(p, alpha);

        System.out.println("Alice escogio el generador: " + mayusAndMinus[1]);
        System.out.println("Bob escogio el generador: " + mayusAndMinus1[1]);

        BigInteger aliceNumber = cliente.decifrar(mayusAndMinus1[0].longValue(), mayusAndMinus[1].longValue(), p);

        BigInteger bobNumber = bob.decifrar(mayusAndMinus[0].longValue(), mayusAndMinus1[1].longValue(), p);

        System.out.println("Alice number is: " + aliceNumber + ", and bob number is: " + bobNumber);
        System.out.println("A is : " + mayusAndMinus[0].longValue());

        //alpha, A, p
        System.out.println("Con algoritmo discreto es: " + AlgoritmoDiscreto.run((int) alpha ,mayusAndMinus[0].intValue(),(int)p));

        System.out.println("Con algoritmo discreto es: " + AlgoritmoDiscreto.run((int) alpha ,mayusAndMinus1[0].intValue(),(int)p));*/


        long p = 131071, alpha = 103;
        /*long p = 3001, alpha = 57;*/
        /*Generadores.run1(p);*/
        Person cliente = new Person();
        BigInteger[] mayusAndMinus = cliente.getMayusAndMinus(p, alpha, 93);


        Person servidor = new Person();
        BigInteger[] mayusAndMinus1 = servidor.getMayusAndMinus(p, alpha, 96);

        System.out.println("Cliente escogio el generador: " + mayusAndMinus[1]);
        System.out.println("Servidor escogio el generador: " + mayusAndMinus1[1]);

        BigInteger aliceNumber = cliente.decifrar(mayusAndMinus1[0].longValue(), mayusAndMinus[1].longValue(), p);

        BigInteger bobNumber = servidor.decifrar(mayusAndMinus[0].longValue(), mayusAndMinus1[1].longValue(), p);

        System.out.println("Cliente number is: " + aliceNumber + ", and Servidor number is: " + bobNumber);
        System.out.println("A is : " + mayusAndMinus[0].longValue());
        System.out.println("B is : " + mayusAndMinus1[0].longValue());

        System.out.println("Con algoritmo discreto es: " + AlgoritmoDiscreto.run(126306 , 2, 135467));

        //alpha, A, p
  System.out.println("Con algoritmo discreto es: " + AlgoritmoDiscreto.run( (int) alpha,mayusAndMinus[0].intValue(),(int)p));

        System.out.println("Con algoritmo discreto es: " + AlgoritmoDiscreto.run((int) alpha ,mayusAndMinus1[0].intValue(),(int)p));





    }
}

