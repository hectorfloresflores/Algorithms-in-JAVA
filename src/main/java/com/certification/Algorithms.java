package com.certification;



import com.sun.istack.internal.NotNull;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import static java.lang.Math.sqrt;


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

class DiscreteLogarithm {

    public static final long NO_SOLUTION = -1;

    private static final HashMap<Long, Long> set = new HashMap<Long, Long>();

    private DiscreteLogarithm() { }

    private static final long pow(long a, long x, long p) {
        if (x == 0)
            return 1;

        if (x == 1)
            return a % p;

        if (x % 2 != 0)
            return (a * pow(a, x - 1, p)) % p;

        final long temp = pow(a, x / 2, p) % p;
        return (temp * temp) % p;
    }

    private static final long getDiscreteLogarithm(HashMap<Long, Long> set, long s, long a, long p) {
        for (long i = 0; i < s; ++i) {
            long el = pow(a, (i * s) % p, p);
            el = pow(el, p - 2, p);

            if (set.containsKey(el))
                return i * s + set.get(el);
        }
        return NO_SOLUTION;
    }

    private static final void generateSet(long a, long b_1, long p, long s, HashMap<Long, Long> set) {
        set.clear();
        for (long i = 0; i < s; ++i) {
            final long first = (pow(a, i, p) * b_1) % p;
            if (!set.containsKey(first))
                set.put(first, i);
        }
    }

    /**
     * Returns DiscreteLogarithm.NO_SOLUTION when a solution cannot be found
     */
    public static final long countDiscreteLogarithm(final long a, final long b, final long p) {
        final long s = (long) sqrt(p) + 1;
        final long b_1 = pow(b, p - 2, p);

        generateSet(a, b_1, p, s, set);
        return getDiscreteLogarithm(set, s,a,p);
    }
}

class AlgoritmoDiscreto
{
    static int run(int a, int alpha, int m)
    {
        int n = (int) (Math.sqrt (m) + 1);

        // Calculate a ^ n
        int an = 1;
        for (int i = 0; i < n; ++i)
            an = (an * a) % m;

        int[] value=new int[m];

        // Store all values of a^(n*i) of LHS
        for (int i = 1, cur = an; i <= n; ++i)
        {
            if (value[ cur ] == 0)
                value[ cur ] = i;
            cur = (cur * an) % m;
        }

        for (int i = 0, cur = alpha; i <= n; ++i)
        {
            // Calculate (a ^ j) * b and check
            // for collision
            if (value[cur] > 0)
            {
                int ans = value[cur] * n - i;
                if (ans < m)
                    return ans;
            }
            cur = (cur * a) % m;
        }
        return -1;
    }

    static long run1(long a, long alpha, long m)
    {
        long n = (long) (Math.sqrt (m) + 1);

        // Calculate a ^ n
        long an = 1;
        for (long i = 0; i < n; ++i)
            an = (an * a) % m;

        long[] value=new long[(int) m];

        // Store all values of a^(n*i) of LHS
        for (long i = 1, cur = an; i <= n; ++i)
        {
            if (value[(int) cur] == 0)
                value[(int) cur] = i;
            cur = (cur * an) % m;
        }

        for (long i = 0, cur = alpha; i <= n; ++i)
        {
            // Calculate (a ^ j) * b and check
            // for collision
            if (value[(int) cur] > 0)
            {
                long ans = value[(int) cur] * n - i;
                if (ans < m)
                    return ans;
            }
            cur = (cur * a) % m;
        }
        return -1;
    }


}

class Mod {
    public static long mod(long number,long mod) {
        if (number % mod < 0)
            return (mod + number % mod);
        return number % mod;
    }
}
public class Algorithms {

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

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger[] cypherAndKey = new BigInteger[2];
        cypherAndKey[0] = message.modPow(e, n);
        cypherAndKey[1] = e.modInverse(phi);

        return cypherAndKey;
    }

    public static BigInteger calculatePrivateKey(BigInteger p, BigInteger q, BigInteger e) {
        BigInteger n = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        return e.modInverse(phi);

    }

    public static BigInteger firmar(BigInteger mensaje, BigInteger privateKey, BigInteger n) {
        return mensaje.modPow(privateKey, n);
    }

    public static BigInteger validarFirma(BigInteger firma, BigInteger e, BigInteger n) {
        return firma.modPow(e, n);
    }

    public static BigInteger[][] encryptRSAMessage(BigInteger p, BigInteger q, BigInteger e, String message) {
        BigInteger[] messageEncrypted = new BigInteger[message.length()];
        BigInteger[][] messageEncryptedandKey = new BigInteger[2][];
        int i = 0;
        BigInteger key = null;
        for (Character a : message.toCharArray()) {

            BigInteger []result = encryptRSA(p,q,e, new BigInteger(String.valueOf((int) a)));
            messageEncrypted[i] = result[0];
            if (i == 0)
                key = result[1];
            i++;
        }


        messageEncryptedandKey[0] = messageEncrypted;
        messageEncryptedandKey[1] = new BigInteger[]{key, p.multiply(q)};
        return messageEncryptedandKey;
    }


    public static BigInteger decrypt(BigInteger privateKey, BigInteger cypherText, BigInteger n) {
        return cypherText.modPow(privateKey, n);

    }

    public static String decryptMessage(BigInteger privateKey, BigInteger[] cypherText, BigInteger n) {
        StringBuilder sb = new StringBuilder();
        for (BigInteger letter : cypherText) {
            sb.append((char) decrypt(privateKey, letter, n).intValue());
        }

        return sb.toString();

    }

    public static void main(String[] args) throws ParseException {
        //Algorithms.eucleanExtended(new BigInteger("49"), new BigInteger("640"));

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
                Arrays.toString(Algorithms.eucleanExtended(new BigInteger("7"), new BigInteger("20"))));
        System.out.println("Compute multiplicative inverse of " + 11 + " modulus " + 47 + " is " +
                Arrays.toString(Algorithms.eucleanExtended(new BigInteger("11"), new BigInteger("47"))));
        System.out.println("Compute multiplicative inverse of " + 50 + " modulus " + 231 + " is " +
                Arrays.toString(Algorithms.eucleanExtended(new BigInteger("50"), new BigInteger("231"))));
        System.out.println("Compute multiplicative inverse of " + 100 + " modulus " + 243 + " is " +
                Arrays.toString(Algorithms.eucleanExtended(new BigInteger("100"), new BigInteger("243"))));*/

        /**
         * 4.-Perform encryption and decryption using the RSA algorithm for the following:
         * p = 3; q = 11, e = 7; M = 5
         * p = 5; q = 11, e = 3; M = 9
         *  p = 7; q = 11, e = 17; M = 8
         *  p = 11; q = 13, e = 11; M = 7
         *  p = 17; q = 31, e = 7; M = 2
         *
         *  (24,471,416 dec)
         *     q=24 58 69 54 (609,773,908 dec)
         *     m=A4 1D 89 1E (2,753,399,070 dec)
         *     e=98 AA 14 56 (2,561,283,158 dec)
         */

        //p, q, e for message
      /*  BigInteger pqe[] = Arrays.stream(new String[]{"24498259", "19477279", "25208587"})
                .map(BigInteger::new)
                .toArray(BigInteger[]::new);

        String message = "HOLA SOY UN SECRETO";
        BigInteger encryoted[][] = encryptRSAMessage(pqe[0], pqe[1], pqe[2], message);

        System.out.println("The message encrypted is: " + message);
        Arrays.stream(encryoted[0]).forEach(System.out::println);
        String decrypted = decryptMessage(encryoted[1][0], encryoted[0], encryoted[1][1]);
        System.out.println("The message encrypted is: " + decrypted);*/

  /*      //e tienes que ser menor que phi !!1
        //Firmar mensaje
        //p, q, e, mensaje
        BigInteger mensaje =  new BigInteger("568");
        BigInteger []encry = encryptRSA(
                new BigInteger("101"), new BigInteger("109"), new BigInteger("10001"),
               mensaje);
        //mensaje, privatekey, n
        BigInteger firma = firmar(new BigInteger("568"), encry[1], new BigInteger("11009"));

        //tiene que ser igual al mensaje
        BigInteger validarFirma = validarFirma(firma, new BigInteger("10001"), new BigInteger("11009"));

        //calculate private key
        //p, q, e
        //la llave publica es la n y la e. (n, e)
        BigInteger privateKey = calculatePrivateKey(new BigInteger("683"), new BigInteger("9001"), new BigInteger("65537"));

        BigInteger privateKey1 = calculatePrivateKey(new BigInteger("166916207082655475839248697236260825427837131883197216699184876472698715467255267318678225463491283825231192252899217904604628621590071458831779210196412114933315871013063513520795127723139621215814231339118976140002143406074750422930684459995185784144245971976950956871421221746630362817153900283455126449971"),
                new BigInteger("155341241452330061495835821353055421228016002934983614250154563638304432501607455167607019805042075885628239252143178762314697215025880654465087390087970294117295687988669904987449355309742374706203787123121015757846465451865563006875074725027186844534613498631528589854663709347762481363479214565134214103040"),
                new BigInteger("65537"));

        BigInteger hola = new BigInteger("45090626990409359972288358056084166157328996444145645125296897756954222772320").modPow(privateKey1,
                new BigInteger("25928970826733909406663627200630580760942185592058641844529394124609759773738393563351766720957240835610358092126890203015724387151301438189220881433608408476975701076588552247118907222556763921619449285055950428807733174431387457903636737686466677514199749974779807966515783889792613662829175312350984774772536878506877787785861854462876216729455372876145226448072669620457115705998042356578661600919390057350282491293831416473540733301872938837654172681640454772792798754041654550394746828460589769924391246069197550592874285642717749550333193427259023071598787590733385163001148894171642761397378576187637199011840"));
        BigInteger firmaDigital = firmar( new BigInteger("45090626990409359972288358056084166157328996444145645125296897756954222772320"),
                privateKey1,
                new BigInteger("25928970826733909406663627200630580760942185592058641844529394124609759773738393563351766720957240835610358092126890203015724387151301438189220881433608408476975701076588552247118907222556763921619449285055950428807733174431387457903636737686466677514199749974779807966515783889792613662829175312350984774772536878506877787785861854462876216729455372876145226448072669620457115705998042356578661600919390057350282491293831416473540733301872938837654172681640454772792798754041654550394746828460589769924391246069197550592874285642717749550333193427259023071598787590733385163001148894171642761397378576187637199011840"));


        BigInteger firmaVerificada = validarFirma(firmaDigital, new BigInteger("65537"), new BigInteger("25928970826733909406663627200630580760942185592058641844529394124609759773738393563351766720957240835610358092126890203015724387151301438189220881433608408476975701076588552247118907222556763921619449285055950428807733174431387457903636737686466677514199749974779807966515783889792613662829175312350984774772536878506877787785861854462876216729455372876145226448072669620457115705998042356578661600919390057350282491293831416473540733301872938837654172681640454772792798754041654550394746828460589769924391246069197550592874285642717749550333193427259023071598787590733385163001148894171642761397378576187637199011840"));*/


        /*
        * Examen ejercicio primer par
        *
        * p = 16778401
        * q = 16888393
        * n = 283360229999593
        * phi = (p-1)(q-1) = 283360196332800
         * e = 65537
         * d = 32418858844673
        * */
        BigInteger d1 = calculatePrivateKey(new BigInteger("16778401"), new BigInteger("16888393"), new BigInteger("65537"));

        /*
         * Examen ejercicio segundo par
         *
         * p = 17658373
         * q = 17658077
         * n = 311812910128721
         * phi = (p-1)(q-1) = 311812874812272
         * e = 65537
         * d = 260257199217329
         * firma = 70993084326349
         * */
        BigInteger d2 = calculatePrivateKey(new BigInteger("17658373"), new BigInteger("17658077"), new BigInteger("65537"));

        BigInteger firma = firmar(new BigInteger("107"), new BigInteger("260257199217329"), new BigInteger("311812910128721"));

        /*
         * Examen ejercicio tercer par
         *
         * p = 16234399
         * q = 19214413
         * n = 311934447192787
         * phi = (p-1)(q-1) = 311934411743976
         * e = 65537
         * d = 144969991194257
         * */
        BigInteger d3 = calculatePrivateKey(new BigInteger("16234399"), new BigInteger("19214413"), new BigInteger("65537"));

        /*
         * Examen ejercicio cuerto par
         *
         * p = 16778227
         * q = 16668229
         * n = 279663329849983
         * phi = (p-1)(q-1) = 279663296403528
         * e = 65537
         * d = 189043802645417
         * */
        BigInteger d4 = calculatePrivateKey(new BigInteger("16778227"), new BigInteger("16668229"), new BigInteger("65537"));

        /*
         * Examen ejercicio quinto par
         *
         * p = 16999399
         * q = 16334401
         * n = 277675000024999
         * phi = (p-1)(q-1) = 277674966691200
         * e = 65537
         * d = 34967293286273
         * */
        BigInteger d5 = calculatePrivateKey(new BigInteger("16999399"), new BigInteger("16334401"), new BigInteger("65537"));


        BigInteger prime = new BigInteger("166916207082655475839248697236260825427837131883197216699184876472698715467255267318678225463491283825231192252899217904604628621590071458831779210196412114933315871013063513520795127723139621215814231339118976140002143406074750422930684459995185784144245971976950956871421221746630362817153900283455126449971");
        BigInteger p1  = prime.nextProbablePrime();
        BigInteger q1  = p1.nextProbablePrime();

        /*BigInteger prime = new BigInteger("166916207082655475839248697236260825427837131883197216699184876472698715467255267318678225463491283825231192252899217904604628621590071458831779210196412114933315871013063513520795127723139621215814231339118976140002143406074750422930684459995185784144245971976950956871421221746630362817153900283455126449971");*/
        BigInteger p2  = q1.nextProbablePrime();
        BigInteger q2  = p2.nextProbablePrime();

        BigInteger private1 = calculatePrivateKey(p1, q1, new BigInteger("65537"));
        BigInteger private2 = calculatePrivateKey(p2, q2, new BigInteger("65537"));
       /* int[] array = new int[]{31, 37, 17, 0};
        BigInteger[] arrays = Arrays.stream(array)
                .mapToObj(BigInteger::valueOf)
                .toArray(BigInteger[]::new);
        BigInteger[] d = encryptRSA(arrays[0], arrays[1], arrays[2], arrays[3]);
        System.out.println(d[1]);
        System.out.println("Message decrypted of " + 2 + " is " + decrypt(d[1], new BigInteger("2"), arrays[0].multiply(arrays[1])) + " and private key is " + 2);*/

        /*System.out.println(Euclean.phi(1080));*/

/*        System.out.println("Compute multiplicative inverse of " + 535 + " modulus " + 273 + " is " +
                Arrays.toString(Algorithms.eucleanExtended(new BigInteger("535"), new BigInteger("273"))));

        System.out.println(Euclean.gcd(535, 273));*/

      /* int alpha = 13335, A = 7, p = 65537;
        System.out.println(AlgoritmoDiscreto.run(A,alpha,p));*/


        /*
        -------------------------------------------
         */



    }
}
