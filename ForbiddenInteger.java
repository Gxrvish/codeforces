
import java.io.*;
import java.util.*;

public class ForbiddenInteger {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {

        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    // Debug Function
    static void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    public static void main(String[] args) throws IOException {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                // write code here
                long n = in.nextLong();
                long k = in.nextLong();
                long x = in.nextLong();

                // Check if x is not equal to 1
                if (x != 1) {
                    System.out.println("YES"); // Output YES since we can form n using 1s
                    System.out.println(n); // The number of integers used is n
                    for (int i = 1; i <= n; i++) {
                        System.out.print(1 + " "); // Output n number of 1s
                    }
                    System.out.println();
                } else {
                    // If x is 1, check if k is 1 or if k is 2 and n is odd
                    if (k == 1 || (k == 2 && n % 2 == 1)) {
                        System.out.println("NO"); // Output NO since it's not possible to form n
                    } else {
                        System.out.println("YES"); // Output YES since it's possible to form n
                        if (n % 2 == 0) {
                            System.out.println(n / 2); // Output the number of integers used
                            for (int i = 1; i <= n / 2; i++) {
                                System.out.print(2 + " "); // Output n/2 number of 2s
                            }
                            System.out.println();
                        } else {
                            System.out.println((n - 3) / 2 + 1); // Output the number of integers used
                            for (int i = 1; i <= (n - 3) / 2; i++) {
                                System.out.print(2 + " "); // Output (n-3)/2 number of 2s
                            }
                            System.out.println(3); // Output a 3 to make the sum n
                        }
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
