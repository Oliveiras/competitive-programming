package spoj;

import static spoj.DynamicProgramming.memoize;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
import utils.FastReader;
import utils.FastWriter;

/*
1. naive recursion - 2000 items
(não finalizou execução após 5 horas)

2. Dynamic Programming / top-down (Map) - 2000 items
33584
55970ms

3. Dynamic Programming / top-down (int[][]) - 2000 items
33584
80ms

4. Dynamic Programming / bottom-up - 2000 items
33584
68ms
 */

public class Knapsack {

    static FastReader in = new FastReader(System.in);
    static FastWriter out = new FastWriter(System.out);

    static Item[] items;

    public static void main(String[] args) throws IOException {

        int maxCapacity = in.nextInt();
        int totalItems = in.nextInt();

        items = new Item[totalItems];
        for (int i = 0; i < totalItems; i++) {
            items[i] = new Item(in.nextInt(), in.nextInt());
        }

//        prepareTable(maxCapacity, totalItems); // 3, 4
//        fillTable(maxCapacity, totalItems); // 4

//        int sumOfValues = solve(maxCapacity, 0); // 1
        int sumOfValues = memoize(maxCapacity, 0); // 2, 3
//        int sumOfValues = tableGet(maxCapacity, 0); // 4

        out.println(sumOfValues);
        out.flush();
    }

    public static int solve(int restCapacity, int currentItem) throws IOException {
        if (currentItem < 0 || items.length <= currentItem) {
            return 0;
        }

        // option A (including currentItem)
        int optionA = 0;
        int size = items[currentItem].size;
        int value = items[currentItem].value;
        if (size <= restCapacity) {
            optionA = value + solve(restCapacity - size, currentItem + 1); // 1
//            optionA = value + memoize(restCapacity - size, currentItem + 1); // 2, 3
//            optionA = value + tableGet(restCapacity - size, currentItem + 1); // 4
        }

        // option B (without currentItem)
        int optB = solve(restCapacity, currentItem + 1); // 1
//        int optB = memoize(restCapacity, currentItem + 1); // 2, 3
//        int optB = tableGet(restCapacity, currentItem + 1); // 4

        int result = Integer.max(optionA, optB);
        return result;
    }

    public static class Item {
        public int size;
        public int value;

        public Item(int size, int value) {
            this.size = size;
            this.value = value;
        }
    }
}

class DynamicProgramming {

    public static Map<Pair<Integer, Integer>, Integer> table = new HashMap<>(); // 2

//    public static int[][] table; // 3, 4

    // 2.

    public static int memoize(int a, int b) throws IOException {
        Pair<Integer, Integer> key = new Pair<>(a, b);
        int value = table.getOrDefault(key, -1);
        if (value == -1) {
            value = Knapsack.solve(a, b);
            table.put(key, value);
        }
        return value;
    }

    // 3.

//    public static void prepareTable(int maxA, int maxB) {
//        table = new int[maxA + 1][maxB + 1];
//        for (int i = 0; i < maxA + 1; i++) {
//            Arrays.fill(table[i], -1);
//        }
//    }
//
//    public static int memoize(int a, int b) throws IOException {
//        int value = table[a][b];
//        if (value == -1) {
//            value = solve(a, b);
//            table[a][b] = value;
//        }
//        return value;
//    }

    // 4.

//    public static void prepareTable(int maxA, int maxB) {
//        table = new int[maxA + 1][maxB + 1];
//        for (int i = 0; i < maxA + 1; i++) {
//            Arrays.fill(table[i], 0);
//        }
//    }
//
//    public static void fillTable(int maxCapacity, int numOfItems) throws IOException {
//        for (int i = 0; i <= maxCapacity; i++) {
//            for (int j = numOfItems - 1; j >= 0; j--) {
//                int value = solve(i, j);
//                table[i][j] = value;
//            }
//        }
//    }
//
//    public static int tableGet(int i, int j) {
//        if (0 <= i && i < table.length && 0 <= j && j < table[i].length) {
//            return table[i][j];
//        } else {
//            return 0;
//        }
//    }
}