package spoj;

import java.io.IOException;
import utils.FastReader;
import utils.FastWriter;

public class Divsum {

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        FastWriter out = new FastWriter(System.out);

        int numOfTests = in.nextInt();
        for (int i = 0; i < numOfTests; i++) {
            long x = in.nextLong();
            out.println(sumOfProperDivisors(x));
        }

        out.flush();
    }

    private static long sumOfProperDivisors(long x) {
        long sum = 1;
        long i = 1;
        long j = x;
        long limit = (long) Math.sqrt(x);

        if (x == 1) return 0;

        while (true) {
            i++;
            j = x / i;

            if (i > limit) break;

            if (i * j == x) {
                sum += i;
                if (i != j)
                    sum += j;
            }
        }
        return sum;
    }
}
