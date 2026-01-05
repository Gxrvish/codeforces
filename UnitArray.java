
import java.io.*;
import java.util.*;

public class UnitArray {

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
                int n = in.nextInt();
                int numberOfNegatives = 0;
                int numberOfPositives = 0;
                for (int i = 0; i < n; i++) {
                    int num = in.nextInt();
                    if (num == -1) {
                        numberOfNegatives++;
                    } else {
                        numberOfPositives++;
                    }
                }
                if (numberOfNegatives % 2 == 0 && numberOfNegatives < numberOfPositives) {
                    out.println("0");
                } else {
                    if (numberOfPositives > numberOfNegatives) {
                        out.println("1");
                    } else {
                        int count = numberOfNegatives - (n / 2);
                        if ((numberOfNegatives - count) % 2 != 0) {
                            count++;
                        }
                        out.println(count);
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
