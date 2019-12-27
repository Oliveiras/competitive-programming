package topcoder;

public class AB {

    public String createString(int n, int k) {
        int x = 1;
        int y;

        if (k == 0) {
            return makeBab(n, 0, 0);
        }

        while (x <= k / 2) {
            y = k / x;
            if ( (x + y > n) || (x * y != k) ) {
                x++;
                continue;
            } else {
                return makeBab(n, x, y);
            }
        }
        return "";
    }

    private String makeBab(int n, int x, int y) {
//        if (x > n || y > n) {
//            throw new IllegalArgumentException("x and y cannot be greater than n");
//        }
        int w = n - (x + y);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < w; i++) {
            sb.append('B');
        }
        for (int i = 0; i < x; i++) {
            sb.append('A');
        }
        for (int i = 0; i < y; i++) {
            sb.append('B');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AB().createString(3, 2));
        System.out.println(new AB().createString(2, 0));
        System.out.println(new AB().createString(5, 8));
        System.out.println(new AB().createString(10, 12));
        System.out.println(new AB().createString(50, 625));
    }
}
