import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

//    public static void main(String[] args) throws IOException {
//        long before = System.currentTimeMillis();
//        Knapsack.main(args);
//        long after = System.currentTimeMillis();
//        System.out.printf("%dms\n", (after - before));
//    }

    static FastReader in = new FastReader(System.in);
    static FastWriter out = new FastWriter(System.out);

    static Item[] items;
    static int[][] table;

    public static void main(String[] args) throws IOException {

        int maxCapacity = in.nextInt();
        int numOfTests = in.nextInt();

        items = new Item[numOfTests];
        table = new int[maxCapacity + 1][numOfTests + 1];
        for (int i = 0; i < numOfTests; i++) {
            items[i] = new Item(in.nextInt(), in.nextInt());
        }

        int sumOfValues = solve(maxCapacity, 0);
        out.println(sumOfValues);

        out.flush();
    }

    private static int solve(int restCapacity, int _) throws IOException {
        Arrays.sort(items, Comparator.<Item>comparingInt(o -> o.value).reversed());
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            if (restCapacity > items[i].size) {
                total += items[i].value;
                restCapacity -= items[i].size;
            }
            if (restCapacity == 0) break;
        }
        return total;
    }

    static class Item {
        public int size;
        public int value;

        public Item(int size, int value) {
            this.size = size;
            this.value = value;
        }
    }

}

final class FastReader extends BufferedReader {

    StringTokenizer tokenizer;

    public FastReader(InputStream in) {
        super(new InputStreamReader(in));
    }

    public FastReader(String fileName) throws FileNotFoundException {
        super(new FileReader(fileName));
    }

    public String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            tokenizer = new StringTokenizer(readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
final class FastWriter extends PrintWriter {

    public FastWriter(OutputStream out) {
        super(out);
    }

    public FastWriter(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void printAll(char separator, Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                print(separator);
            }
            print(objects[i]);
        }
    }
}
