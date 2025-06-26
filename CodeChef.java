
import java.io.*;
import java.util.*;

class CodeChef {

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

    // GCD
    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // LCM
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    // Prime Check
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Sieve of Eratosthenes
    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // Modular Exponentiation
    static long modExp(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // Factorial Modulo
    static long factorialMod(int n, int mod) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % mod;
        }
        return result;
    }

    // Custom Comparator for Sorting
    static class Pair implements Comparable<Pair> {

        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.first, o.first); // Ascending order by first
        }
    }

    // Prefix Sum
    static int[] prefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    // Binary Search
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }

    static void addDivisors(int n, HashSet<Integer> set) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
    }

    static long minCost(int X, int Y, int Z, int C) {
        long g = gcd(X, Y);
        long l = lcm(X, Y);

        long ans = Long.MAX_VALUE;

        // 0 operations: just change Z directly to gcd or lcm (if allowed)
        ans = Math.min(ans, Math.abs(Z - g));
        ans = Math.min(ans, Math.abs(Z - l));

        // 1 operation: change Z + 1 gcd/lcm operation
        ans = Math.min(ans, Math.abs(Z - g) + C);
        ans = Math.min(ans, Math.abs(Z - l) + C);

        // Collect divisors of X and Y as possible intermediate steps
        HashSet<Integer> candidates = new HashSet<>();
        addDivisors(X, candidates);
        addDivisors(Y, candidates);

        // 2 operations: change Z to d + change d to gcd or lcm + 2 operations cost
        for (int d : candidates) {
            long costG = Math.abs(Z - d) + Math.abs(d - g) + 2L * C;
            long costL = Math.abs(Z - d) + Math.abs(d - l) + 2L * C;
            ans = Math.min(ans, Math.min(costG, costL));
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                // write code here

                int x = in.nextInt();
                int y = in.nextInt();
                int z = in.nextInt();
                int c = in.nextInt();
                out.println(minCost(x, y, z, c));
                // Map<Integer, Integer> freq = new TreeMap<>(); // stores element -> count
                // for (int i = 0; i < n; i++) {
                //     int num = sc.nextInt();
                //     freq.put(num, freq.getOrDefault(num, 0) + 1); // increment count
                // }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
