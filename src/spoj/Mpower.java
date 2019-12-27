package spoj;

import java.io.IOException;
import java.math.BigInteger;
import utils.FastReader;
import utils.FastWriter;

public class Mpower {

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        FastWriter out = new FastWriter(System.out);

        int numOfTests = in.nextInt();
        for (int i = 0; i < numOfTests; i++) {
            solveLine(in, out);
        }

        out.flush();
    }

    private static void solveLine(FastReader in, FastWriter out) throws IOException {
        BigInteger x = new BigInteger(in.next());
        BigInteger y = new BigInteger(in.next());
        BigInteger n = new BigInteger(in.next());
        out.println(x.modPow(y, n));
    }

}
